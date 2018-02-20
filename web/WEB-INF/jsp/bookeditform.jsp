<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Book</h1>
<form:form method="POST" action="/MyLibraryApp2/editsave">
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="book_id" /></td>
        </tr>
        <tr>
            <td>ISBN : </td>
            <td><form:input path="isbn"  /></td>
        </tr>
        <tr>
            <td>Title :</td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Genre :</td>
            <td><form:input path="genre" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /></td>
        </tr>
    </table>
</form:form>