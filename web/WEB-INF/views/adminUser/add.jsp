<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/common/ueditorScript.jsp"></c:import> 
		 <div class="tbl_defalut">
			<table border="1">
			<colgroup><col style="width:120px">
			<col>

			</colgroup><tbody>
			<tr>
				<th>date<span title="date11111" class="point">*</span></th>
				<td>
					<select name="">
					<option>date</option>
					<option>date</option>
					<option>date</option>
					<option>date</option>
					<option>date</option>
					<option>date</option>
					<option>date</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>date <span title="date" class="point">*</span></th>
				<td><input type="text" title="date" class="input" style="width:150px"><a href="#" class="btn_sml"><span>date</span></a></td>
			</tr>
			<tr>
				<th>date</th>
				<td><textarea cols="30" rows="5"></textarea></td>
			</tr>
			<tr>
				<th>Editor</th>
				<td>
					<c:import url="/WEB-INF/editor.jsp"></c:import> 
				</td>
			</tbody>
			</table>
		</div>
		
		
