package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.ProductDao;
import kr.ac.hansung.cse.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	

	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}

	public void updateProduct(Product product) {
/*		MultipartFile multipartFile = product.getMultipartFile();
		String fileName = UPLOAD_LOCATION + multipartFile.getOriginalFilename();
		// Now do something with file...
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				FileCopyUtils.copy(multipartFile.getBytes(), file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		product.setImageName(multipartFile.getOriginalFilename());
		product.setMultipartFile(null);*/

		productDao.updateProduct(product);
	}

}
