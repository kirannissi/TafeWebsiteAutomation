# WebShop Testing Challenge

As Demo web shop is ecommerce application which is expected to have a lot of areas to test. I believe the sole reason to visit a shopping site is to browse for some products or to buy something that user is interested. I believe the following five areas are high risk to test in this application.
Five high risk areas of the are listed below:
* Products is the main part of the application that attract new users or to keep hold of existing users.
* Login is one of the key areas for an existing user whether to view order history or browse through the site and save to Wishlist or to buy something.
* As per the layout of this application Shopping cart is the bridge to complete an order (checkout).
* Global Search is the place where most of the users start their activity in the application to find what they need.
* Checkout is the final step to complete any transaction and plays a vital role in the success of the business.

As I have to automate two test cases, so I am covering happy paths of Global Search and Checkout and ignoring any negative paths. when I search for a product, availability of the product is already covered by seeing the search results. Whereas, to complete a checkout we need to cross the shopping cart bridge and select a product. Also, users have an option to place an order as Guest. So, Login is not mandatory for everyone. 

##Steps to Run the Project
1) Download [IntelliJ](https://download.jetbrains.com/idea/ideaIC-2021.3.3.exe?_gl=1*1rwqxw8*_ga*MTY2MDgxMDgyMC4xNjQ2OTExMzcz*_ga_9J976DJZ68*MTY1NTYzMDAxNS4xLjEuMTY1NTYzMDAzNi4w&_ga=2.215772766.898116640.1655630015-1660810820.1646911373 "Intellij 2021.3.3") 
2) Click 'Install Anyway' if prompted
3) Click 'Yes' if prompted
4) 'Intellij Community Edition Setup' should open by now
5) Click 'Next'
6) and select prompts as required
7) Launch 'IntelliJ' after successful installation
8) Select 'Get from VCS'
9) Switch to VCS
10) paste the Git [link](https://github.com/manojkumar-bandlamudi/WebShop.git "Git Repo link") in 'URL'
11) Update directory if needed
12) click 'Clone'
13) Please wait cloning might take couple of minutes 
14) Select 'Trust Project' if prompted 
15) Navigate to 'JunitTestRunner' java class 
16) Right click and select Run 'JunitTestRunner' 
17) This will start test execution 
18) This will take 5-10 mins 
19) Wait until cucumber report gets generated 
20) Click the link under 'View your Cucumber Report at:' to view the final report
21) A beautiful report with screenshots and test data will be displayed


