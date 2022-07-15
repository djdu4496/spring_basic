package com.fastcampus.ch2;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
//		return User.class.equals(clazz); // �����Ϸ��� ��ü�� UserŸ������ Ȯ��
		return User.class.isAssignableFrom(clazz); // clazz�� User �Ǵ� �� �ڼ����� Ȯ��
	}


	public void validate(Object target, Errors errors) { 
		System.out.println("UserValidator.validate() is called");

		User user = (User)target;
		
		String id = user.getId();
		
		// ���� ���� - Validator�� ���� �����ϰ�, Validate()�� ���� ȣ��
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		
		if(id==null || id.length() <  5 || id.length() > 12) {
			errors.rejectValue("id", "invalidLength");
		}
	}
}