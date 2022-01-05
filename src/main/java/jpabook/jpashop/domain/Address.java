package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Address {
	
	public Address(String city, String street, String zipcode) {
	}

	private String city;
	
	private String street;
	
	private String zipcode;

}
