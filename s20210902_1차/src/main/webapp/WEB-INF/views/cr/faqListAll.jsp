<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PIB FAQ</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
 
<!--   <script type="text/javascript">
  	$('.title').onclick(function() {
		$(this).next().slideToggle();
	});
  </script> -->
    <script type="text/javascript">
	     function faqList(num){
	     	$('.title'+num).next().slideToggle().siblings('.content').slideUp();
	        /*  if($('.title'+num).next().css('display') == 'none'){
		        $('.title'+num).next().slideToggle();
		    }else{
		        $('.title'+num).next().slideUp();
		    } */
	    } 
    </script>
    <style type="text/css">
    	.customer_service {
    		margin-top: 30px;
    	}
    
    	.customer_service ul {
    		list-style: none;
    		display: block;
    	}
    	.customer_service ul li {
    		position: relative;
		    float: left;
		    width: 340px;
		    text-align: center;
		    border: 0;
    	}
    	.customer_service ul li a {
    		display: block;
		    height: 50px;
		    padding: 0;
		    line-height: 50px;
		    background: #f6f6f6;
		    font-size: 18px;
		    color: #666;
		    font-weight: 500;
		    border-left: 1px solid #e6e6e6;
    	}
    	.customer_service ul li.on a {
    		background: #555 !important;
		    color: #fff;
		    border: 0;
    	}
    	
    	.customer_service_category {
    		margin-top: 30px;
    		text-align: center;
    		margin-bottom: 30px;
    	}
    
    	.customer_service_category ul {
    		list-style: none;
    		display: block;
    		
    	}
    	.customer_service_category ul li {
    		position: relative;
		    float: left;
		    padding-right:20px;
		    text-align: center;
		    border: 0;
    	}
    	 .customer_service_category ul li a {

		    font-size: 17px;
		    color: #999;
		  
    	}
    	.customer_service_category ul li.on a {
    		background: #555 !important;
		    color: #fff;
		    border: 0;
    	} 
    </style>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__option">
            <div class="offcanvas__links">
                <a href="#">Sign in</a>
                <a href="#">FAQs</a>
            </div>
            <div class="offcanvas__top__hover">
                <span>Usd <i class="arrow_carrot-down"></i></span>
                <ul>
                    <li>USD</li>
                    <li>EUR</li>
                    <li>USD</li>
                </ul>
            </div>
        </div>
        <div class="offcanvas__nav__option">
            <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
            <a href="#"><img src="img/icon/heart.png" alt=""></a>
            <a href="#"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
            <div class="price">$0.00</div>
        </div>
        <div id="mobile-menu-wrap"></div>
       
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-7">
                		
                    </div>
                    <div class="col-lg-6 col-md-5">
                        <div class="header__top__right">
                            <div class="header__top__links">
                            <c:choose>
                            <c:when test="${mem_id == null }">
                                <a href="cm/register">회원가입</a>
                                <a href="cm/loginForm">로그인</a>
                            </c:when>
                            <c:when test="${mem_id != null && mem_admin == 0}">
                                <span style="color: white; padding-right: 20px;">${mem_id }님</span>
                                <a href="cm/logout">로그아웃</a>
                                <a href="myPageForm">마이페이지</a>
                            </c:when>
                            <c:when test="${mem_admin == 1 }">
                            	<span style="color: white; padding-right: 20px;">${mem_id }님</span>
                                <a href="cm/logout">로그아웃</a>
                                <a href="adminPageForm">관리자페이지</a>
                            </c:when>
                            </c:choose>
                                <a href="faqListAll">고객센터</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="home"><img src="img/PIB_logo.png" alt="" width="120px" height="50px"></a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <nav class="header__menu mobile-menu">
                        <ul>
                            <li><a href="bhPro">All</a></li>
                            <li><a href="bhProT">Tops</a></li>
                            <li><a href="bhProB">Trousers</a></li>
                            <li><a href="bhProA">Accessories</a></li>
                            <li><a href="bhProS">Shoes</a></li>
                            <!-- <ul class="dropdown">
                                    <li><a href="./about.html">About Us</a></li>
                                    <li><a href="./shop-details.html">Shop Details</a></li>
                                    <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                                    <li><a href="./checkout.html">Check Out</a></li>
                                    <li><a href="./blog-details.html">Blog Details</a></li> 
                                </ul> -->
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3 col-md-3">
                    <div class="header__nav__option">
                        <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
                        <a href="wishList"><img src="img/icon/heart.png" alt=""></a>
                        <a href="cartList"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
                    </div>
                </div>
            </div>
            <div class="canvas__open"><i class="fa fa-bars"></i></div>
        </div>
    </header>
    <!-- Header Section End -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>고객센터</h4>
                        <div class="breadcrumb__links">
                            <a href="home">Home</a>
                            <span>FAQ</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section>
    <div class="container">
    <div class="row">
    	<div class="col-lg-12 col-md-5">
	    	<div class="customer_service">
	    	<ul>
	    		<li class="on"><a href="faqListAll">FAQ</a></li>
	    		<li><a href="qnaClientList">1:1문의</a></li>
	    		<li><a href="noticeList">공지사항</a></li>
	    	</ul>
	    	</div>
    	</div>
    	<div class="col-lg-12 col-md-5">
    	<div class="customer_service_category">
    	<ul>
    		<li><a href="faqListAll">전체</a></li>
    		<li><a href="faqListAll?q_mcode=310">제품</a></li>
    		<li><a href="faqListAll?q_mcode=320">배송</a></li>
    		<li><a href="faqListAll?q_mcode=330">교환/환불</a></li>
    		<li><a href="faqListAll?q_mcode=340">주문결제</a></li>
    		<li><a href="faqListAll?q_mcode=350">기타</a></li>
    	</ul>
    	</div>
    	</div>
    </div>
    	<div class="shopping__cart__table">
    		<ul style="list-style: none;">
    			<c:forEach var="faq" items="${faqList }">
    			<c:set var="cnt" value="${cnt+1 }" />
    			<%-- <li id="faqListId${cnt}" class="faqHide" style="border-top: 1px solid gray;"> --%>
    				<input type="hidden" value="${faq.f_num }">
    				<div class="title${cnt }" onclick="faqList(${cnt})" style="padding: 30px;border-top: 1px solid gray;">
							<span class="cate" style="padding-right: 30px;">${faq.content }&nbsp;&nbsp;-&nbsp;&nbsp; </span>
							<span class="title2">${faq.f_title }</span>
					</div>
					<div class="content" style="display: none; padding :30px; background-color: rgb(238,238,238);">
						<pre>${faq.f_content}</pre>
					</div>
    			<!-- </li> -->
    			</c:forEach>
    		</ul>
    	</div>
    	<div>
    		<c:if test="${page.startPage > page.pageBlock }">
				<a href="faqListAll?q_mcode=${faq.q_mcode }&currentPage=${page.startPage - page.pageBlock }">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${page.startPage }" end="${page.endPage }">
				<a href="faqListAll?q_mcode=${faq.q_mcode }&currentPage=${i }">[${i }]</a>
			</c:forEach>
			<c:if test="${page.endPage < page.totalPage }">
				<a href="faqListAll?q_mcode=${faq.q_mcode }&currentPage=${page.startPage + page.pageBlock }">[다음]</a>
			</c:if>
    	</div>
    	</div>
    </section>

    <!-- Footer Section Begin -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__logo">
                            <a href="home"><img src="img/PIB_logo_white1.png" alt=""></a>
                        </div>
                        <p>Providing Incomparable Beauty</p>
                        <img src="img/payment.png" alt="">
                    </div>
                </div>
                <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
                    <div class="footer__widget">
                        <h6>Shopping</h6>
                        <ul>
                        	<li><a href="bhPro">All</a></li>
                            <li><a href="bhProT">Top</a></li>
                            <li><a href="bhProB">Trousers</a></li>
                            <li><a href="bhProA">Accessories</a></li>
                            <li><a href="bhProS">Shoes</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-6">
                    <div class="footer__widget">
                        <h6>Service Center</h6>
                        <ul>
                            <li><a href="faqListAll">FAQ</a></li>
                            <li><a href="#">NOTICE</a></li>

                        </ul>
                    </div>
                </div>
                <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
                    <div class="footer__widget">
                        <h6>PIB - People In Black</h6>
                        <div class="footer__newslatter">
                            <p>Motivated and inspired by the Hollywood blockbuster movie Men In Black, 
								the goal of our company is to provide simplicity and equality to each and every one of our customers.
								Our website was made by Group2 who were first assembled in "Choongang Institute".</p>
                            <!-- <form action="#">
                                <input type="text" placeholder="Your email">
                                <button type="submit"><span class="icon_mail_alt"></span></button>
                            </form> -->
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="footer__copyright__text">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        <p>Copyright ©
                            <script>
                                document.write(new Date().getFullYear());
                            </script>2020
                            All rights reserved | This template is made with <i class="fa fa-heart-o"
                            aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        </p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/jquery.countdown.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>

</body>

</html>