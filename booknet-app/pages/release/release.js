// pages/release/release.js
import Dialog from '../../lib/vant-weapp/dist/dialog/dialog';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    active_tab: 0,
    book_pub:{
      name:'',
      price: 0,
      desc:'',
      contact:'' //联系方式
    },
    ask_pub:{
      name:'',
      desc:'',
      contact:'' //联系方式
    },
    book_pub_errors:{
      name:'',      // onChangeBookName
      price:'',     // onChangeBookPrice
      desc:'',       // onChangeBookDesc
      contact:'' // onChangeBookContact
    },
    ask_pub_errors:{
      name:'',      // onChangeAskName
      desc:'',       // onChangeAskDesc
      contact:'' // onChangeAskContact
    },
    images:[        // images 为图片上传数组对象
      /**
       * 
        参数	说明
        url	图片和视频的网络资源地址
        name	文件名称，视频将在全屏预览时作为标题显示
        thumb	图片缩略图或视频封面的网络资源地址，仅对图片和视频有效
        type	文件类型，可选值image video file
        isImage	手动标记图片资源
        isVideo	手动标记视频资源
       */
    ]       
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if (typeof this.getTabBar === 'function' &&
    this.getTabBar()) {
    this.getTabBar().setData({
        active: 2
      })
    }
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  // 转让贴与求书贴标签转换事件
  tabOnChange: function(event) {
    // wx.showToast({
    //   title: `切换到标签 ${event.detail.name}`,
    // })
  },

  // 转让贴书名输入事件
  onChangeBookName: function(event){
    let name = event.detail.trim();
    if(name == ''){
      this.setData({'book_pub_errors.name':'请输入书名'})
    }else{
      this.setData({'book_pub_errors.name':'','book_pub.name':name})
    }
  },

  // 转让贴价格输入事件
  onChangeBookPrice: function(event){
    var regPos = /^\d+(\.\d+)?$/;
    if(!regPos.test(event.detail)){
      this.setData({'book_pub_errors.price':'请输入售价'})
    }else{
      this.setData({'book_pub_errors.price':'','book_pub.price':event.detail})
    }
  },

  // 转让贴内容输入事件
  onChangeBookDesc: function(event){
    if(event.detail == '' || typeof(event.detail) == 'undefined'){
      this.setData({'book_pub_errors.desc':'书籍相关信息不能为空'})
    }else{
      this.setData({'book_pub_errors.desc':'','book_pub.desc':event.detail})
    }
  },

  // 转让贴联系方式输入事件
  onChangeBookContact: function(event){
    if(event.detail == '' || typeof(event.detail) == 'undefined'){
      this.setData({'book_pub_errors.contact':'联系方式不能为空'})
    }else{
      this.setData({'book_pub_errors.contact':'','book_pub.contact':event.detail})
    }
  },

  // 求书贴书名输入事件
  onChangeAskName: function(event){
    let name = event.detail.trim();
    if(name == ''){
      this.setData({'ask_pub_errors.name':'请输入书名'})
    }else{
      this.setData({'ask_pub_errors.name':'','ask_pub.name':name})
    }
  },

  // 求书贴内容输入事件
  onChangeAskDesc: function(event){
    if(event.detail == '' || typeof(event.detail) == 'undefined'){
      this.setData({'ask_pub_errors.desc':'帖子不能为空'})
    }else{
      this.setData({'ask_pub_errors.desc':'','ask_pub.desc':event.detail})
    }
  },

  // 求书贴联系方式输入事件
  onChangeAskContact: function(event){
    if(event.detail == '' || typeof(event.detail) == 'undefined'){
      this.setData({'ask_pub_errors.contact':'联系方式不能为空'})
    }else{
      this.setData({'ask_pub_errors.contact':'','ask_pub.contact':event.detail})
    }
  },

  // 求书贴上传书籍图片，文件上传完毕后会触发after-read回调函数，获取到对应的文件的临时地址，然后再使用wx.uploadFile将图片上传到远程服务器上
  afterRead: function(event){
    const { file } = event.detail;
    // console.log(file)

    const { images = [] } = this.data;
    images.push({ ...file, url: file.url });
    this.setData({ images });
    // 当设置 mutiple 为 true 时, file 为数组格式，否则为对象格式
    // wx.uploadFile({
    //   url: 'https://example.weixin.qq.com/upload', // 仅为示例，非真实的接口地址
    //   filePath: file.url,
    //   name: 'file',
    //   formData: { user: 'test' },
    //   success(res) {
    //     // 上传完成需要更新 fileList
    //     const { fileList = [] } = this.data;
    //     fileList.push({ ...file, url: res.data });
    //     this.setData({ fileList });
    //   },
    // });
  },
  
  // 求书贴删除选中图片
  deleteImage: function(event){
    const { images = [] } = this.data;
    images.shift()
    this.setData({images})
  },

  // 发布书籍转让贴按钮
  // 书籍转让贴概要内容：如果desc字符数大于76则仅截取前73个字符加上后缀“...”
  bookPubSubmit: function(){
    console.log(this.data.book_pub)
    // 1.校验表单内容合法性
    // 2.调用后台接口，上传内容
    // 3.通知发布成功
    Dialog.alert({
      message:'发布成功'
    })
    // 4.发布成功后重置表单内容
    this.setData({
      'book_pub.name':'',
      'book_pub.price':0,
      'book_pub.desc': '',
      'book_pub.contact':'',
      images:[]
    })
  },

  // 求书贴发布按钮
  // 求书贴概要内容：如果desc字符数大于67则仅截取前64个字符加上后缀“...”
  askPubSubmit: function(){
    console.log(this.data.ask_pub)
    // 1.校验表单内容合法性
    // 2.调用后台接口，上传内容
    // 3.通知发布成功
    Dialog.alert({
      message:'发布成功'
    })
    // 4.发布成功后重置表单内容
    this.setData({
      'ask_pub.name':'',
      'ask_pub.desc':'',
      'ask_pub.contact':'',
    })
  }
})
