package com.application.Hibernateproject;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;

public class hibernatecontroller {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter phone number: ");
        long phoneNumber = scanner.nextLong();
        scanner.close();
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        hibernate h = new hibernate();
        h.setName(name);
        h.setEmail(email);
        h.setPassword(password);
        h.setPhonenumber(phoneNumber);
        s.save(h);
        t.commit();
        System.out.println("Successfully Inserted");
        s.close();
        sf.close();
    }
}
