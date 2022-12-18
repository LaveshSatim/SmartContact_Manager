package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, String> {

}
