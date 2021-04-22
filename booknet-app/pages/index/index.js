// index.js
// 获取应用实例
const app = getApp()
const utils = require("../../utils/util")

Page({
  data: {
    value : '',
    page : 1,
    book_list:[
      {
        id: 1,
        price:'8.00',
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。", 
        book:"平凡的世界",
        image: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
    ],
  },

  onShow: function(){
    let instance = this
    // 判断用户信息
    if(typeof app.globalData.userInfo == null || app.globalData.userInfo == null){
      wx.getSetting({
        success: (res) => {
          // 检查是否授权用户信息
          if(res.authSetting['scope.userInfo']){
            wx.getUserInfo({
              success: (res) => {
                console.log("用户信息")
                console.log(res)
                app.globalData.userInfo = res.userInfo
                // 登录状态查询
                wx.getStorage({
                  key: 'token',
                  success: res => {
                    if(typeof(res.data) == 'undefined' || res.data == ''){
                      // this.login()
                      utils.initLogin()
                    }else{
                      wx.checkSession({
                        // session_key未过期
                        success() {
                          let num = instance.data.page
                          let promise = utils.get('http://www.booknet.com/app/search/books/get/' + num)
                          promise.then((value) => {
                            instance.setData({
                              book_list: value.data.data
                            })
                          })
                        },
                        // sesssion_key已过期
                        fail(){
                          // this.login()
                          utils.initLogin()
                        }
                      })
                    }
                  },
                  fail(){
                    // this.login()
                    utils.initLogin()
                  }
                })
              }
            })
          }else{
            wx.navigateTo({
              url: '/pages/authorize/authorize',
            })
          }
        }
      })
    }


    // tabbar active设置
    if (typeof this.getTabBar === 'function' &&
    this.getTabBar()) {
    this.getTabBar().setData({
        active: 0
      })
    }
  },

  // 搜索框查找监听事件
  onSearch: function(event){
    console.log(event.detail);
    wx.navigateTo({
      url: '/pages/search/search?detail=' + event.detail,
    })
  },

  // onLoad: function(){
  //   wx.login({
  //     success: res => {
  //       console.log("app.js login")
  //       console.log(res)
  //       // 获取用户授权状态
  //       wx.getSetting({
  //         success: (res) => {
  //           // 检查是否授权用户信息
  //           if(res.authSetting['scope.userInfo']){
  //             wx.getUserInfo({
  //               success: (res) => {
  //                 console.log("用户信息")
  //                 console.log(res)
  //               }
  //             })
  //           }else{
  //             wx.navigateTo({
  //               url: '/pages/authorize/authorize',
  //             })
  //           }
  //         }
  //       })
  //       // 发送 res.code 到后台换取 openId, sessionKey, unionId
  //     }
  //   })
  // },
 
  // 选中书籍条目跳转事件
  selectBook: function(event){
    let index = event.currentTarget.dataset.index;
    let book_id = this.data.book_list[index].id
    wx.navigateTo({
      url: '/pages/book/book?index='+book_id,
    })
  },

  // 下拉刷新
  onPullDownRefresh: function(){
    let instance = this
    let promise = utils.get('http://www.booknet.com/app/search/books/get/1')
    promise.then((value) => {
      instance.setData({
        book_list: value.data.data,
        page: 1
      })
      wx.stopPullDownRefresh({
        success: (res) => {},
      })
    })
  },

  // 滚动触底事件
  onReachBottom: function(){
    let instance = this
    let num = instance.data.page + 1
    let promise = utils.get('http://www.booknet.com/app/search/books/get/' + num)
    promise.then((value) => {
      if(value.data.code == 200){
        let list = instance.data.book_list.concat(value.data.data)
        instance.setData({
          book_list: list,
          page: num
        })
      }
    })
  }


})

/**
 *     book_list:[
      {
        id: 1,
        price:'8.00',
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。", 
        book:"平凡的世界",
        image: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"0.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://bkimg.cdn.bcebos.com/pic/14ce36d3d539b600fbdea00ee950352ac65cb773?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2UxMTY=,g_7,xp_5,yp_5/format,f_auto',
      },
      {
        price:"0.00",
        desc:"《活着》讲述一个人一生的故事，这是一个历尽世间沧桑和磨难老人的人生感言，是一幕演绎人生苦难经历的戏剧。。",
        title:"活着",
        imageURL: 'https://bkimg.cdn.bcebos.com/pic/09fa513d269759ee2ed8752cb2fb43166c22df48?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U4MA==,g_7,xp_5,yp_5/format,f_auto',
      },
      {
        price:"5.00",
        desc:"《时间简史》是英国物理学家斯蒂芬·威廉·霍金创作的科普著作，首次出版于1988年。全书共十二章，讲述了关于宇宙本性的最前沿知识.",
        title:"时间简史",
        imageURL: 'https://bkimg.cdn.bcebos.com/pic/0bd162d9f2d3572c2b694f428d13632763d0c3a1?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U5Mg==,g_7,xp_5,yp_5/format,f_auto',
      },
      {
        price:"3.00",
        desc:"《活着》讲述一个人一生的故事，这是一个历尽世间沧桑和磨难老人的人生感言，是一幕演绎人生苦难经历的戏剧。",
        title:"活着",
        imageURL: 'https://bkimg.cdn.bcebos.com/pic/09fa513d269759ee2ed8752cb2fb43166c22df48?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U4MA==,g_7,xp_5,yp_5/format,f_auto',
      },
      {
        price:"6.00",
        desc:"《时间简史》是英国物理学家斯蒂芬·威廉·霍金创作的科普著作，首次出版于1988年。全书共十二章，讲述了关于宇宙本性的最前沿知识.",
        title:"时间简史",
        imageURL: 'https://bkimg.cdn.bcebos.com/pic/0bd162d9f2d3572c2b694f428d13632763d0c3a1?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U5Mg==,g_7,xp_5,yp_5/format,f_auto',
      },
 */