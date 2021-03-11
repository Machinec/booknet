// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    value : '',
    book_list:[
      {
        price:2.00,
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      },
      {
        price:"2.00",
        desc:"《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。",
        title:"平凡的世界",
        imageURL: 'https://img3.doubanio.com/lpic/s27964262.jpg',
      }
    ],
  },

  onShow: function(){

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
  // }
})
