
package com.info.springboot.crud.repositories;
import java.util.List;

import com.info.springboot.crud.entity.Book;

public interface BookRepositoryCustom {
	
	
  
    public List<Book> getFabricInfoById(Integer id);
    
	
}
