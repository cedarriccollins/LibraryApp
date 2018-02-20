<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Book List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>ISBN</th><th>Title</th><th>Genre</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="book" items="${list}">
        <tr>
            <td>${book.book_id}</td>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td><a href="editbook/${book.book_id}">Edit</a></td>
            <td><a href="deletebook/${book.book_id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="bookform">Add New Book</a>