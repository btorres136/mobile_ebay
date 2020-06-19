package edu.mobile.ebay.Controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mobile.ebay.DAO.Entities.Bids;
import edu.mobile.ebay.DAO.Entities.Customers;
import edu.mobile.ebay.DAO.Entities.Departments;
import edu.mobile.ebay.DAO.Entities.ProductOwners;
import edu.mobile.ebay.DAO.Entities.Products;
import edu.mobile.ebay.DAO.LDAP.LDAPManager;
import edu.mobile.ebay.DAO.Repositories.BidsRepo;
import edu.mobile.ebay.DAO.Repositories.CustomersRepo;
import edu.mobile.ebay.DAO.Repositories.DepartmentsRepo;
import edu.mobile.ebay.DAO.Repositories.ProductOwnersRepo;
import edu.mobile.ebay.DAO.Repositories.ProductsRepo;

@Controller
public class WebController {

    @Autowired
    private BidsRepo bidRepo;

    @Autowired
    private CustomersRepo customerRepo;

    @Autowired
    private ProductsRepo productsRepo;

    /*@Autowired
    private SalesRepo salesRepo;*/

    @Autowired
    private ProductOwnersRepo productownersrepo;

    @Autowired
    private LDAPManager ldap;

    @Autowired
    private DepartmentsRepo departments_repo;

    @GetMapping(value = { "/", "/index" })
    public String index(Model model, Principal user, Authentication auth) {
        if (user != null && auth.isAuthenticated()) {
			if(customerRepo.findByCustomerID(user.getName()).getEnable() != 1){
            	model.addAttribute("user", user.getName());
				return "AccountDisable";
			}
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);

            boolean isAdmin = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_ADMINS")));
            model.addAttribute("isAdmin", isAdmin);
        }
        List<Departments> dep = departments_repo.findalldepartments();
        model.addAttribute("dep", dep);
        return "Menu";
    }

    @GetMapping("/login")
    public String Login(Principal user) {
        if (user != null && ((Authentication) user).isAuthenticated()) {
            return "redirect:/";
        }
        return "Login";
    }

    @GetMapping("/SignUp")
    public String SignUp(Principal user) {
        if (user != null && ((Authentication) user).isAuthenticated()) {
            return "redirect:/";
        }
        return "SignUp";
    }

    @GetMapping("/category/{id}")
    public String category(Model model, @Nullable Principal user, @Nullable Authentication auth,
            @PathVariable("id") Long dep_id) {
        if (user != null && auth.isAuthenticated()) {	
			if(customerRepo.findByCustomerID(user.getName()).getEnable() != 1){
            	model.addAttribute("user", user.getName());
				return "AccountDisable";
			}
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);

            boolean isAdmin = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_ADMINS")));
            model.addAttribute("isAdmin", isAdmin);
        }

        List<Products> prod = productsRepo.findProductbyDepartment(dep_id);
        model.addAttribute("products", prod);
        ArrayList<Integer> bid = new ArrayList<>();
        for (int i = 0; i < prod.size(); i++) {
            bid.add(bidRepo.getMaxId(prod.get(i).getProductsID()));
        }
        model.addAttribute("bid", bid);

        List<Departments> dep = departments_repo.findalldepartments();
        model.addAttribute("dep", dep);
        return "All_Products";
    }

    @PostMapping("/SignUp")
    public String SignUp(@RequestParam("username") String username, @RequestParam("lastname") String lastname,
            @RequestParam("uid") String uid, @RequestParam("email") String email,
            @RequestParam("password") String password) {
        if (!customerRepo.existsByCustomerID(uid)) {
            Customers customer = new Customers();
            customer.setCustomerID(uid);
            customer.setName(username);
            customer.setRating(0);
            long millis = System.currentTimeMillis();
            customer.setAccountCreated(new Date(millis));
            customerRepo.save(customer);
            ldap.create(username, lastname, uid, email, password);
        }
        return "redirect:/login";
    }

    @GetMapping("/sec/ProductOwner/Products/Add")
    public String AddProduct(Principal user, Model model, Authentication auth) {	
		if(customerRepo.findByCustomerID(user.getName()).getEnable() != 1){
            model.addAttribute("user", user.getName());
			return "AccountDisable";
		}else if(customerRepo.findByCustomerID(user.getName()).getProductOwnersID().getEnable() != 1){
            model.addAttribute("user", user.getName());
			return "AccountDisable";
		}
        boolean isProductOwner = auth.getAuthorities().stream()
                .anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch((authority -> authority.getAuthority().equals("ROLE_ADMINS")));
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("user", user.getName());
        model.addAttribute("isProductOwner", isProductOwner);

        List<Departments> dep = departments_repo.findalldepartments();
        model.addAttribute("dep", dep);


        return "AddProduct";
    }

    @PostMapping("/sec/ProductOwner/Products/Add")
    public String AddtoProducts(Model model, @RequestParam("startingbid") int startingbid,
            @RequestParam("ProductTitle") String Title, HttpServletRequest request,
            @RequestParam("Description") String Description,
            @RequestParam("department_search") Long dep_id,
            @RequestParam("status") String status,
            @RequestParam("endbid") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date enddate,
            @RequestParam("img") MultipartFile Img, Principal user) throws IllegalStateException, IOException {
		if(customerRepo.findByCustomerID(user.getName()).getEnable() != 1){
            model.addAttribute("user", user.getName());
			return "AccountDisable";
		}else if(customerRepo.findByCustomerID(user.getName()).getProductOwnersID().getEnable() != 1){
            model.addAttribute("user", user.getName());
			return "AccountDisable";
		}
        Products product = new Products();
        UUID uuid = UUID.randomUUID();
        if (!Img.isEmpty()) {
            String actualPath = "/UserIMG/" + user.getName() + "/" + uuid.toString() + Img.getOriginalFilename();
            String path = request.getSession().getServletContext()
                    .getRealPath("/UserIMG/" + user.getName() + "/" + uuid.toString() + Img.getOriginalFilename());
            File dirPath = new File(path);
            if (!dirPath.exists()) {
                dirPath.mkdirs();
            }
            product.setImagePath(actualPath);
            Img.transferTo(dirPath);
        } else {
            product.setImagePath("/IMG/img-not-available.png");
        }
        long millis = System.currentTimeMillis();
        product.setProductsID(uuid.toString());
        product.setProductOwnersID(customerRepo.findByCustomerID(user.getName()).getProductOwnersID());
        product.setStartBid(new Date(millis));
        product.setDescription(Description);
        product.setItemPath("/item/" + uuid);
        product.setEndBid(enddate);
        product.setState(status);
        product.setTitle(Title);
        product.setDepartmentId(departments_repo.finddepartments(dep_id));
        product.setEnable(1);
        productsRepo.save(product);

        Bids bid = new Bids();
        bid.setBidQuantity(startingbid);
        bid.setBidTimeSet(new Date(millis));
        bid.setCustomerID(customerRepo.findByCustomerID(user.getName()));
        bid.setProductsID(productsRepo.findByproductsID(uuid.toString()));
        bidRepo.save(bid);
        return "redirect:/Products";
    }

    @GetMapping("/item/{id}")
    private String showItem(@PathVariable("id") String id, Model model, @Nullable Principal user,
            @Nullable Authentication auth) {
        Products prod = productsRepo.findByproductsID(id);
        model.addAttribute("prod", prod);
        int bid = bidRepo.getMaxId(prod.getProductsID());
        model.addAttribute("bid", bid);
        if (user != null && auth.isAuthenticated()) {
			if(customerRepo.findByCustomerID(user.getName()).getEnable() != 1){
            	model.addAttribute("user", user.getName());
				return "AccountDisable";
			}
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);

            boolean isAdmin = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_ADMINS")));
            model.addAttribute("isAdmin", isAdmin);
        }
        List<Departments> dep = departments_repo.findalldepartments();
        model.addAttribute("dep", dep);
        return "Product";
    }

    @GetMapping("/Search")
    private String Search(@RequestParam("department_search") int dept, @RequestParam("product") String product,
            Model model, @Nullable Principal user, @Nullable Authentication auth) {
        if (user != null && auth.isAuthenticated()) {
			if(customerRepo.findByCustomerID(user.getName()).getEnable() != 1){
            	model.addAttribute("user", user.getName());
				return "AccountDisable";
			}
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);

            boolean isAdmin = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_ADMINS")));
            model.addAttribute("isAdmin", isAdmin);
        }
        if (dept != 0) {
            List<Products> products = productsRepo.findProductByKeyWordandDepartment(product, dept);
            model.addAttribute("products", products);
            ArrayList<Integer> bid = new ArrayList<>();
            for (int i = 0; i < products.size(); i++) {
                bid.add(bidRepo.getMaxId(products.get(i).getProductsID()));
            }
            model.addAttribute("bid", bid);
        } else {
            List<Products> products = productsRepo.findProductByKeyWord(product);
            model.addAttribute("products", products);
            ArrayList<Integer> bid = new ArrayList<>();
            for (int i = 0; i < products.size(); i++) {
                bid.add(bidRepo.getMaxId(products.get(i).getProductsID()));
            }
            model.addAttribute("bid", bid);
        }
        List<Departments> dep = departments_repo.findalldepartments();
        model.addAttribute("dep", dep);
        return "All_Products";
    }

    @GetMapping("/Products")
    private String Products(Model model, @Nullable Principal user, @Nullable Authentication auth) {
        boolean isAdmin = false;
        if (user != null && auth.isAuthenticated()) {
			if(customerRepo.findByCustomerID(user.getName()).getEnable() != 1){
            	model.addAttribute("user", user.getName());
				return "AccountDisable";
			}
            model.addAttribute("user", user.getName());
            boolean isProductOwner = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
            model.addAttribute("isProductOwner", isProductOwner);

            isAdmin = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_ADMINS")));
            model.addAttribute("isAdmin", isAdmin);
        }
        List<Products> prod;
        if(isAdmin){
            prod = productsRepo.findAllAdmin();
        }else{
            prod = productsRepo.findAllProducts();
        }
        model.addAttribute("products", prod);
        ArrayList<Integer> bid = new ArrayList<>();
        for (int i = 0; i < prod.size(); i++) {
            bid.add(bidRepo.getMaxId(prod.get(i).getProductsID()));
        }
        model.addAttribute("bid", bid);
        List<Departments> dep = departments_repo.findalldepartments();
        model.addAttribute("dep", dep);
        return "All_Products";
    }

    @PostMapping("/sec/product/addbid")
    public String addbid(Model model, @RequestParam("productid") String prodid, Principal user, @RequestParam("bid") int bidval) {
		if(customerRepo.findByCustomerID(user.getName()).getEnable() != 1){
            model.addAttribute("user", user.getName());
			return "AccountDisable";
		}
        long millis = System.currentTimeMillis();
        Bids bid = new Bids();
        bid.setBidQuantity(bidval);
        bid.setBidTimeSet(new Date(millis));
        bid.setCustomerID(customerRepo.findByCustomerID(user.getName()));
        bid.setProductsID(productsRepo.findByproductsID(prodid));
        bidRepo.save(bid);
        return "redirect:/item/" + prodid;
    }

    @GetMapping("/sec/admin")
    public String admin(Model model, Authentication auth) {
        boolean isProductOwner = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_PRODUCTOWNER")));
        model.addAttribute("isProductOwner", isProductOwner);
        boolean isAdmin = auth.getAuthorities().stream()
                    .anyMatch((authority -> authority.getAuthority().equals("ROLE_ADMINS")));
        model.addAttribute("isAdmin", isAdmin);
        List<Customers> customers = customerRepo.findAllCustomers();
        model.addAttribute("customers", customers);
        List<ProductOwners> productOwners = productownersrepo.findAll();
        model.addAttribute("productowners", productOwners);
		List<Departments> departments = departments_repo.findAll();
		model.addAttribute("departments",departments);
        return "Admin";
    }

    @PostMapping("/sec/admin/disable/item")
    public String disableItem(@RequestParam("productid") String productid){
        productsRepo.disableproduct(productid);
        return "redirect:/Products";
    }

    @PostMapping("/sec/admin/enable/item")
    public String enableItem(@RequestParam("productid") String productid){
        productsRepo.enableproduct(productid);
        return "redirect:/Products";
    }

	@PostMapping("/sec/admin/disable/productOwner")
	public String disableproductItem(@RequestParam("productownerid") Long productownerid){
 		productownersrepo.disableproductowner(productownerid);	
		return "redirect:/sec/admin";	
	}

	@PostMapping("/sec/admin/enable/productOwner")
	public String enableproductowner(@RequestParam("productownerid") Long productownerid){
		productownersrepo.enableproductowner(productownerid);
		return "redirect:/sec/admin";
	}
    @PostMapping("/sec/admin/disable/department")
    public String disableDepartment(@RequestParam("departmentid") Long departmentid){
        departments_repo.disabledepartment(departmentid);
        return "redirect:/sec/admin";
    }

    @PostMapping("/sec/admin/enable/department")
    public String enableDepartment(@RequestParam("departmentid") Long departmentid){
        departments_repo.enabledepartment(departmentid);
        return "redirect:/sec/admin";
    }

    @PostMapping("/sec/admin/disable/customer")
    public String disableCustomer(@RequestParam("customerid") String customerid){
		customerRepo.disablecustomer(customerid);
		return "redirect:/sec/admin";
    }

    @PostMapping("/sec/admin/enable/customer")
    public String enableCustomer(@RequestParam("customerid") String customerid){
        customerRepo.enablecustomer(customerid);
        return "redirect:/sec/admin";
    }

	@PostMapping("/sec/admin/add/department")
	public String addDepartment(@RequestParam("departmentname") String departmentname, @RequestParam("departmentdescription") String departmentdescription){
		Departments department = new Departments();
		department.setEnable(1);
		department.setDescription(departmentdescription);
		department.setDepartmentName(departmentname);
		departments_repo.save(department);
		return "redirect:/sec/admin";
	}

	@PostMapping("/sec/admin/add/customer")
	public String addCustumer(@RequestParam("customername") String customerName, @RequestParam("customerid") String customerId){ 
		Customers customer = new Customers();
		customer.setName(customerName);
		customer.setCustomerID(customerId);
		customer.setEnable(1);
		customer.setRating(0);
		Long millis = System.currentTimeMillis();
		customer.setAccountCreated(new Date(millis));
		customerRepo.save(customer);
		return "redirect:/sec/admin";	
	}	

	@PostMapping("/sec/admin/add/productOwner")
	public String addProductOwner(@RequestParam("customerid") String customerId, @RequestParam("description") String description){
		ProductOwners productOwner = new ProductOwners();
		productOwner.setEnable(1);
		productOwner.setRating(0);
		productOwner.setDescription(description);
		productOwner.setSalesMade(0);
		productOwner.setCustomerID(customerRepo.findByCustomerID(customerId));
		productownersrepo.save(productOwner);
		return "redirect:/sec/admin";
	}

	@GetMapping("/sec/admin/add/department")
	public String addDepartment(){
		return "AddDepartment";
	}

	@GetMapping("/sec/admin/add/customer")
	public String addCustomer(){
		return "AddCustomer";
	}

	@GetMapping("/sec/admin/add/productowner")
	public String addproductOwner(){
		return "AddProductOwner";
	}
}
