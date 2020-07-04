#SSM实验作业一： 文件的上传与下载

##第三方jar:
~~~ xml
    <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.3.3</version>
    </dependency>
~~~

## 主要代码
~~~ java
      @RequestMapping("/fileDownload")
      public ResponseEntity<byte[]> fileDownload(@RequestParam("fileName") String fileName,
                                                 HttpServletRequest request,
                                                 Model model) throws IOException {
          //下载文件路径
          String path = request.getServletContext().getRealPath("/upload/");
          //创建文件对象
          File file = new File(path + File.separator + fileName);
          //设置响应头
          HttpHeaders headers = new HttpHeaders();
          //下载以后显示文件名解决中文名乱码问题
          String downloadFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
          //通知浏览器一下载(attachment)方式返回文件数据
          headers.setContentDispositionFormData("attachment", downloadFileName);
          //使用Spring MVC框架的ResponseEntity对象封装返回下载数据
          return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
      }
  
      @RequestMapping("/fileUpload")
      public String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                               HttpServletRequest request,
                               ModelMap model) {
          // 服务器端upload文件夹物理路径
          String path = request.getSession().getServletContext().getRealPath("upload");
          // 获取文件名
          String fileName = file.getOriginalFilename();
          // 实例化一个file对象，表示目标文件（包含物理路径）
          File targaetFile = new File(path, fileName);
          if (!targaetFile.exists()) {
              targaetFile.mkdirs();
          }try {
              // 将上传文件写到服务器上的指定文件
              file.transferTo(targaetFile);
          } catch (IOException e) {
              e.printStackTrace();
          }
  //        model.put("fileUrl", request.getContextPath() + "/upload/" + fileName);
          model.put("fileUrl", path+ "\\" + fileName);
          model.put("fileName", fileName);
          return "success";
      }
  
      @GetMapping("/file")
      public String file() {
          return "file";
      }

~~~

## 实验结果


