package com.tactfactory.monsuperprojet.converters;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Converter
public class StringToBcryptConverter implements AttributeConverter<String, String> {

  @Override
  public String convertToDatabaseColumn(String attribute) {
    String idForEncode = "bcrypt";
    Map<String, PasswordEncoder> encoders = new HashMap<String, PasswordEncoder>();
    encoders.put(idForEncode, new BCryptPasswordEncoder());

    PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
    return passwordEncoder.encode(attribute);
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    return dbData;
  }

}
