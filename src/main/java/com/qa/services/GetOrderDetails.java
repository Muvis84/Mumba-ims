package com.qa.services;
import java.util.List;

import com.qa.customer.domain.*;

public interface GetOrderDetails<O, I, C> {
	
List<O> orderdetailsDisplay(long id);

}
