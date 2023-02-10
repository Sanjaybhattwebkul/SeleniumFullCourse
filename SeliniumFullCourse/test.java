TakesScreenshot ss = ((TakesScreeshot)driver).getScreenshotAs(OutPutType.FILE);
FileUtils.copyFile(ss,new File("path.png"));

HttpURLConnection conn = new URL(href).openConnection();
conn.setRequestMethod("HEAD");
conn.connect();
if(conn.getResponseMethod()> 400){
    System.out.println("this is broken link");
}

String name = "SANJAY BHATT WEBKUL";
String[] nameArray = name.split(" ");
for (int i=nameArray.length-1;i>=0;i--) {
    System.out.print(nameArray[i]+ " ");
}


1  2  3  

4  5  6 
 
7  8  9

int[] metrix = {{1,2,}, {4,5,6},{7,8,9}}
int[] nim = metrix[0][0];
int minRow = 0;

for (int i=0; i<3;i++) {
    for (int j =0; j<3 j++) {
        if (metrix[i][j]>min) {
            min = metrix[i][j]
            minRow = j;
        }
    }
}

System.out.print(min);