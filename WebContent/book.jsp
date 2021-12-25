
<!DOCTYPE html>
<html class="h-100" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>SVIST</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="../../assets/images/favicon.png">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body class="h-100">
    
    <!--*******************
        Preloader start
    ********************-->
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->

      <div class="nav-header">
            <div class="brand-logo">
                <a href="index.html">
                        <img src="images/avatar/13.jpg" width="80" height="50"  alt="centered image">
                </a>
            </div>
        </div>
        
          <div class="drop-down dropdown-profile   dropdown-menu">
                                <div class="dropdown-content-body">
                                    <ul>
                                       
                                        <li><a href="login.jsp"><i class="icon-key"></i> <span>Logout</span></a></li>
                                    </ul>
                                </div>
                            </div>
                            
                            
                             <div class="nk-sidebar">           
            <div class="nk-nav-scroll">
                <ul class="metismenu" id="menu">
                    <li class="nav-label">Dashboard</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-speedometer menu-icon"></i><span class="nav-text">Dashboard</span>
                        </a>
                        
                    </li>
                   
                    <li class="nav-label">Apps</li>
                    
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-screen-tablet menu-icon"></i><span class="nav-text">Apps</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="/ClassRoom/LimageController">Profile</a></li>
                            <li><a href="./calander.jsp">Calender</a></li>
                        </ul>
                    </li>
                   
                   <li class="nav-label">Book Store</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-menu menu-icon"></i><span class="nav-text">Book Store</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="/ClassRoom/RequestfetchController" aria-expanded="false">Request Book</a></li>
                           
                        </ul>
                    </li>
                    <li class="nav-label">Pages</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-notebook menu-icon"></i><span class="nav-text">Pages</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./login.jsp">Login</a></li>
                            <li><a href="./librarianRegistration.jsp">Library Register</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>



    <div class="login-form-bg h-100">
        <div class="container h-100">
            <div class="row justify-content-center h-100">
                <div class="col-xl-6">
                    <div class="form-input-content">
                        <div class="card login-form mb-0">
                            <div class="card-body pt-5">
                                
                                    <a class="text-center" href="index.html"> <h4>Book</h4></a>
        
                                <form action="ProcessController" method="post" class="mt-5 mb-5 login-input">
                                <%String id = request.getParameter("id"); %>
                                     <input type="hidden" value="<%=id %>" name="tranjection_id">
                                    <div class="form-group">
                                        <input type="date" name="last_date_of_submission"   class="form-control" placeholder="Last_date_submission" required>
                                    </div>
                                    <div class="form-group">
                                          <select name="status" class="form-control">
                                          <option>Select</option>
                                           <option value="approved">Approved </option>
                                           <option value="declined">Declined </option>
                                       
                               
                                        </select>
                                    </div>
                                     <div class="form-group">
                                        <select name="message" class="form-control">
                                           <option>Select</option>
                                        <option value="Book is not available">Book is not available</option>
                                        <option value="You don't submit book in previous semester">You don't submit book in previous semester</option>
                                        <option value="This writer's book does't use in our college">This writer's book does't use in our college</option>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn login-form__btn submit w-100">Submit</button>
                                </form>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    

    

    <!--**********************************
        Scripts
    ***********************************-->
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>
</body>
</html>





