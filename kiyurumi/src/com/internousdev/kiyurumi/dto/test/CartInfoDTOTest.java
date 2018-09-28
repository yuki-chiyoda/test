package com.internousdev.kiyurumi.dto.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.internousdev.kiyurumi.dto.CartInfoDTO;

public class CartInfoDTOTest {
	int max = 2147483647;
	int min = -2147483648;
	String exmax = "2147483648";
	String exmin = "-2147483649";

	@Test
	public void testGetId1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0 ;

		dto.setId(expected);
		int actual = dto.getId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetId2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647 ;

		dto.setId(expected);
		int actual = dto.getId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetId3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483647 ;

		dto.setId(expected);
		int actual = dto.getId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetId4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMax = Integer.parseInt("2147483647");
			dto.setId(postalMax);

		}catch (RuntimeException e) {
			assertEquals(e.getMessage(),"For input string:\"2147483648\"");
		}
	}
	@Test
	public void testGetId5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMin = Integer.parseInt("-2147483647");
			dto.setId(postalMin);

		}catch (RuntimeException e) {
			assertEquals(e.getMessage(),"For input string:\"-2147483648\"");
		}
	}


	@Test
	public void testSetId1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setId(expected);
		int actual= dto.getId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetId2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setId(expected);
		int actual= dto.getId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetId3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483647;

		dto.setId(expected);
		int actual= dto.getId();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetId4() {
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMax = Integer.parseInt("2147483647");
			dto.setId(postalMax);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string:\"2147483648\"");
		}
	}
	@Test
	public void testSetId5() {
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMin = Integer.parseInt("-2147483647");
			dto.setId(postalMin);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string:\"-2147483648\"");
		}
	}


	@Test
	public void testGetUserId1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUserId12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}


	@Test
	public void testSetUserId1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="0";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="2147483647";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="-2147483647";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="null";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected=" ";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="　";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="abc123";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="あいう１２３";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="abc123あいう１２３";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="abcあいう１２３漢字";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUserId12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="ａｂｃあいう１２３漢字";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTempUserId1() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="0";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId2() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="2147483647";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId3() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="-2147483647";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId4() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="null";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId5() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId6() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected=" ";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId7() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected=" ";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId8() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="　";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId9() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="あいう１２３";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId10() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="abc123あいう１２３";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId11() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="abc123あいう１２３漢字";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetTempUserId12() {
		CartInfoDTO dto=new CartInfoDTO();
		String expected="ａｂｃあいう１２３漢字";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected,actual);
	}


	@Test
	public void testSetTempUserId1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetTempUserId12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setTempUserId(expected);
		String actual = dto.getTempUserId();
		assertEquals(expected, actual);
	}


	@Test
	public void testGetProductId1() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = 0;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductId2() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductId3() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = -2147483647;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductId4() throws Exception {
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMax=Integer.parseInt("2147483648");
			dto.setProductId(postalMax);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}
	@Test
	public void testGetProductId5() throws Exception {
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMin=Integer.parseInt("-2147483648");
			dto.setProductId(postalMin);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}


	@Test
	public void testSetProductId1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductId2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductId3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483647;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductId4() throws Exception {
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMax=Integer.parseInt("2147483648");
			dto.setProductId(postalMax);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}
	@Test
	public void testSetProductId5() throws Exception {
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMin=Integer.parseInt("-2147483648");
			dto.setProductId(postalMin);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}


	@Test
	public void testGetProductCount() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = 0;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductCount2() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductCount3() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = -2147483647;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductCount4() throws Exception{
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMax=Integer.parseInt("2147483648");
			dto.setProductCount(postalMax);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}
	@Test
	public void testGetProductCount5() throws Exception{
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMin=Integer.parseInt("-2147483648");
			dto.setProductCount(postalMin);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}


	public void testSetProductCount1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected =0;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductCount2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected =2147483647;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductCount3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected =-2147483647;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected, actual);
	}


	public void testSetProductCount4() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMax = Integer.parseInt("2147483648");
			dto.setProductCount(postalMax);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	public void testSetProductCount5() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMin = Integer.parseInt("-2147483648");
			dto.setProductCount(postalMin);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}

	@Test
	public void testGetPrice1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetPrice2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 9999999;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPrice3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -9999999;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPrice4() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMax =10000000;
			dto.setPrice(postalMax);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetPrice5() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMax =-10000000;
			dto.setPrice(postalMax);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
		}
	}

	@Test
	public void testSetPrice1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPrice2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 9999999;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPrice3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -9999999;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPrice4() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMax =10000000;
			dto.setPrice(postalMax);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testSetPrice5() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMax =-10000000;
			dto.setPrice(postalMax);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
		}
	}

	@Test
	public void testGetRegistDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setRegistDate(expected);
		Date actual = dto.getRegistDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetRegistDate2() throws ParseException {
		CartInfoDTO dto = new CartInfoDTO();

		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setRegistDate(expected);
		assertEquals(expected, dto.getRegistDate());
	}

	@Test
	public void testSetRegistDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setRegistDate(expected);
		Date actual = dto.getRegistDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetRegistDate2() throws ParseException {
		CartInfoDTO dto = new CartInfoDTO();

		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setRegistDate(expected);
		assertEquals(expected, dto.getRegistDate());
	}

	@Test
	public void testGetUpdateDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setUpdateDate(expected);
		Date actual = dto.getUpdateDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetUpdateDate2() throws ParseException{
		CartInfoDTO dto = new CartInfoDTO();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setUpdateDate(expected);
		assertEquals(expected,dto.getUpdateDate());
	}

	@Test
	public void testSetUpdateDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setUpdateDate(expected);
		Date actual = dto.getUpdateDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetUpdateDate2() throws ParseException{
		CartInfoDTO dto = new CartInfoDTO();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setUpdateDate(expected);
		assertEquals(expected,dto.getUpdateDate());
	}

	@Test
	public void testGetProductName1() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="0";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName2() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="2147483647";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName3() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="-2147483647";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName4() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="null";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName5() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName6() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected =" ";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName7() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="　";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName8() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="abc123";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName9() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="あいう１２３";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName10() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="abc123あいう１２３";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName11() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="abc123あいう１２３漢字";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductName12() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="ａｂｃあいう１２３漢字";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetProductName1() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="0";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName2() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="2147483647";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName3() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="-2147483647";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName4() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="null";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName5() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName6() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected =" ";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName7() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="　";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName8() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="abc123";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName9() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="あいう１２３";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName10() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="abc123あいう１２３";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName11() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="abc123あいう１２３漢字";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductName12() {
		CartInfoDTO dto =new CartInfoDTO();
		String expected ="ａｂｃあいう１２３漢字";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetProductNameKana1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductNameKana12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetProductNameKana1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductNameKana12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetProductDescription1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetProductDescription12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetProductDescription1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetProductDescription12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCategoryId1() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = 0;

		dto.setCategoryId(expected);
		int actual = dto.getCategoryId();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetCategoryId2() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = 2147483647;

		dto.setCategoryId(expected);
		int actual = dto.getCategoryId();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCategoryId3() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = -2147483647;

		dto.setCategoryId(expected);
		int actual = dto.getCategoryId();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCategoryId4() throws Exception{
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMax=Integer.parseInt("2147483648");
			dto.setCategoryId(postalMax);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}
	@Test
	public void testGetCategoryId5() throws Exception{
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMin=Integer.parseInt("-2147483648");
			dto.setCategoryId(postalMin);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}

	@Test
	public void testSetCategoryId1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected =0;

		dto.setCategoryId(expected);
		int actual = dto.getCategoryId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetCategoryId2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected =2147483647;

		dto.setCategoryId(expected);
		int actual = dto.getCategoryId();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetCategoryId3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected =-2147483647;

		dto.setCategoryId(expected);
		int actual = dto.getCategoryId();
		assertEquals(expected, actual);
	}


	public void testSetCategoryId4() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMax = Integer.parseInt("2147483648");
			dto.setCategoryId(postalMax);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	public void testSetCategoryId5() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMin = Integer.parseInt("-2147483648");
			dto.setCategoryId(postalMin);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}

	@Test
	public void testGetImageFilePath1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFilePath12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetImageFilePath() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFilePath12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetImageFileName1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetImageFileName12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetImageFileName1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetImageFileName12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected, actual);
	}


	@Test
	public void testGetBirthDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthDate12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}



	@Test
	public void testSetBirthDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthDate12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setBirthDate(expected);
		String actual = dto.getBirthDate();
		assertEquals(expected, actual);
	}


	@Test
	public void testGetBirthPlace1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="0";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="2147483647";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="-2147483647";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="null";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected=" ";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="　";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlac8e() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="abc123";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="あいう１２３";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="abc123あいう１２３";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="abc123あいう１２３漢字";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetBirthPlace12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="ａｂｃあいう１２３漢字";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}


	@Test
	public void testSetBirthPlace1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="0";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlace2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="2147483647";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSettBirthPlace3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="-2147483647";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlace4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="null";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlace5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlace6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected=" ";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlace7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="　";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlac8e() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="abc123";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlace9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="あいう１２３";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlace10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="abc123あいう１２３";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlace11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="abc123あいう１２３漢字";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetBirthPlace12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected="ａｂｃあいう１２３漢字";

		dto.setBirthPlace(expected);
		String actual = dto.getBirthPlace();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetStatus1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetStatus12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStatus() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "null";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus8() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus9() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "あいう１２３";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus10() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus11() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc123あいう１２３漢字";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetStatus12() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ａｂｃあいう１２３漢字";

		dto.setStatus(expected);
		String actual = dto.getStatus();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetSubtotal1() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = 0;

		dto.setSubtotal(expected);
		int actual = dto.getSubtotal();
		assertEquals(expected, actual);
	}
	@Test
	public void testGetSubtotal2() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = 2147483647;

		dto.setSubtotal(expected);
		int actual = dto.getSubtotal();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetSubtotal3() {
		CartInfoDTO dto= new CartInfoDTO();
		int expected = -2147483647;

		dto.setSubtotal(expected);
		int actual = dto.getSubtotal();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetSubtotal4() throws Exception{
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMax=Integer.parseInt("2147483648");
			dto.setSubtotal(postalMax);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}
	@Test
	public void testGetSubtotal5() throws Exception{
		CartInfoDTO dto= new CartInfoDTO();
		try{
			int postalMin=Integer.parseInt("-2147483648");
			dto.setSubtotal(postalMin);

		}catch(RuntimeException e){
		assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}

	@Test
	public void testSetSubtotal1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected =0;

		dto.setSubtotal(expected);
		int actual = dto.getSubtotal();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetSubtotal2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected =2147483647;

		dto.setSubtotal(expected);
		int actual = dto.getSubtotal();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetSubtotal3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected =-2147483647;

		dto.setSubtotal(expected);
		int actual = dto.getSubtotal();
		assertEquals(expected, actual);
	}


	public void testSetSubtotal4() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMax = Integer.parseInt("2147483648");
			dto.setSubtotal(postalMax);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"2147483648\"");
		}
	}

	public void testSetSubtotal5() throws Exception{
		CartInfoDTO dto = new CartInfoDTO();
		try{
			int postalMin = Integer.parseInt("-2147483648");
			dto.setSubtotal(postalMin);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(),"For input string: \"-2147483648\"");
		}
	}

}
