package com.qa.ims.persistence.domain;

import org.junit.Before;
import org.junit.Test;

import com.qa.customer.domain.Customer;

public class CustomerTest {
	
	private Customer customer;
	private Customer other;
	
	@Before
	public Customer setUp() {
		customer = new Customer(1001, "mumba", "4 boleyn court");
		return other = new Customer(1001, "mumba", " 5 tangamere street");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(customer.getCustomerID());
		assertNotNull(customer.getName());
		assertNotNull(customer.getAddress());
		
		customer.setCustomerID(null);
		assertNotNull(customer.getCustomerID());
		customer.setName(null);
		assertNotNull(customer.getName());
		customer.setAddress(null);
		assertNotNull(customer.getAddress());
		
	}
	
	private void assertNotNull(Long customerID) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	private void assertFalse(boolean equals) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1001, customer.getCustomerID(), 0);
		assertEquals("Chris", customer.getName());
		assertEquals("4 Boleyn court", customer.getAddress());
	}
	
	private void assertEquals(String toString, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(long l, Long customerID, int i) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setName("rhys");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setName(null);
		other.setName(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void nullId() {
		customer.setCustomerID(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customer.setCustomerID(null);
		other.setCustomerID(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setCustomerID(2L);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurname() {
		customer.setAddress(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurnameOnBoth() {
		customer.setAddress(null);
		other.setAddress(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherSurnameDifferent() {
		other.setAddress(" 8 Lantern grove");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("Chris", "Perrins");
		assertNotNull(customer.getCustomerID());
		assertNotNull(customer.getName());
		assertNotNull(customer.getAddress());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(null, null);
		Customer other = new Customer(null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}
	
	private void assertEquals(int hashCode, int hashCode2) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void toStringTest() {
		String toString = "id:1 first name:Chris surname:Perrins";
		assertEquals(toString, customer.toString());
	}
}
