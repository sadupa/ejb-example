import com.mycuteblog.service.Book;
import com.mycuteblog.service.LibraryWebService_Service;

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
 * Created on : 1/25/16 5:23 PM
 */
public class WebServiceTest {
    public static void main(String[] args) {
        LibraryWebService_Service libraryWebService_service = new LibraryWebService_Service();
        List<Book> bookList = libraryWebService_service.getLibraryWebServicePort().getBooks();
        for(Book book:bookList){
            System.out.println(book.getName());
        }
    }
}
