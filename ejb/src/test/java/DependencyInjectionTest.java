import com.mycuteblog.ejb.session.DependencySessionBeanRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.List;

/**
 * (C) Copyright 2016 hSenid Mobile Solutions (Pvt) Limited.
 * All Rights Reserved.
 * <p/>
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
 * of hSenid Mobile Solutions (Pvt) Limited.
 * <p/>
 * hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
 * property rights in these materials.
 *
 * @Author Sadupa Wijeratne
 * Created on : 1/5/16 5:26 PM
 */
public class DependencyInjectionTest {
    private BufferedReader brConsoleReader = null;
    private InitialContext ctx;
    private int choice = 1;

    public DependencyInjectionTest() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        hashtable.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        hashtable.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        try {
            ctx = new InitialContext(hashtable);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        brConsoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        DependencyInjectionTest dependencyInjectionTest = new DependencyInjectionTest();
        dependencyInjectionTest.testStatelessEjb();
    }

    private void showGUI() {
        System.out.println("**********************");
        System.out.println("Welcome to Book Store");
        System.out.println("**********************");
        System.out.print("1. Add Book\n2. Show books\n0. Exit \nEnter Choice: ");
        choice = Integer.parseInt(getInput());
    }

    private void testStatelessEjb() {
        try {
            showGUI();
            while (choice != 0) {
                if (choice == 1) {
                    DependencySessionBeanRemote librarySessionBean = (DependencySessionBeanRemote) ctx.lookup("ejb-ear-1.0-SNAPSHOT/DependencyLibrarySessionBean/remote");
                    System.out.println("Enter book name:");
                    String bookName = getInput();
                    librarySessionBean.addBook(bookName);
                    List<String> books = librarySessionBean.getBooks();
                    System.out.println("Added books\n");
                    for (String book : books) {
                        System.out.println(book);
                    }
                    showGUI();
                } else if (choice == 2) {
                    DependencySessionBeanRemote librarySessionBean2 = (DependencySessionBeanRemote) ctx.lookup("ejb-ear-1.0-SNAPSHOT/DependencyLibrarySessionBean/remote");
                    List<String> books = librarySessionBean2.getBooks();
                    System.out.println("Added books\n");
                    for (String book : books) {
                        System.out.println(book);
                    }
                    showGUI();
                }
            }
            System.out.println("Thank you for using EJB Library System");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private String getInput() {
        try {
            return brConsoleReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
