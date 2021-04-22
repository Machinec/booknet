const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return `${[year, month, day].map(formatNumber).join('/')} ${[hour, minute, second].map(formatNumber).join(':')}`
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : `0${n}`
}

// ES5 function() 关键词定义函数
// var x = function(x, y) {
//   return x * y;
// }

// ES6 箭头函数
// const x = (x, y) => x * y;

// 封装wx.request,携带token请求
const post = (url,data,token) => {
  let promise = new Promise(function(resolve,reject){
    wx.request({
      method: 'POST',
      url: url,
      data:data,  
      header:{
        'content-type': 'application/json',
        'myAuthorization': 'Bearer ' + token
      },
      success(res){
        if(res.data.code == 200 || typeof(res.data.code) == undefined || res.data.code == null){
          resolve(res)
        }else{
          reject(res)
        }
      },
      fail(err){
        reject(err)
      }
    })
  });
  return promise
}
// 封装wx.request
const wxRequest = (url,data) => {
  let promise = new Promise(function(resolve,reject){
    wx.request({
      method: 'POST',
      url: base_url+url,
      data:data,  
      header:{
        'content-type': 'application/json',
      },
      success(res){
        if(res.data.code == 200 || typeof(res.data.code) == undefined || res.data.code == null){
          resolve(res)
        }else{
          reject(res)
        }
      },
      fail(err){
        reject(err)
      }
    })
  });
  return promise
}

// 封装 wx.getStorage
const wxGetStorage = key => {
  let promise = new Promise(function(resolve,reject){
    wx.getStorage({
      key: key,
      success(res){
        resolve(res)
      },
      fail(err){
        reject(err)
      }
    })
  })
  return promise
}

// 服务器返回登录过期后调用，res.data.code = 9527
const login = () =>{
  let app = getApp()
  wx.showModal({
    showCancel: false,
    content: "请重新登录",
    success (res){
      wx.login({
        success (res) {
          if (res.code) {
            //发起网络请求
            wx.request({
              url: 'http://www.booknet.com/app/user/login',
              method: 'POST',
              header: {
                'content-type': 'application/json',
              },
              data:{
                code: res.code,
                user:{
                    name:app.globalData.userInfo.nickName,
                    school:"华南师范大学",
                    avatar:app.globalData.userInfo.avatarUrl
                }
              },
              success: res => {
                console.log(res)
                //保存token
                wx.setStorage({
                  data: token,
                  key: res.data.data,
                })
                //跳转回首页
                wx.navigateTo({
                  url: '/pages/index/index',
                })
              },
              fail: err =>{
                console.log(err)
              }
            })
          } else {
            console.log(res.errMsg)
          }
        }
      })
    }
  })

}

// 初始index.js登录调用
const initLogin = () =>{
  let app = getApp()
  let school_name = "华南师范大学"
  wx.login({
    success (res) {
      if (res.code) {
        //发起网络请求
        wx.request({
          url: 'http://www.booknet.com/app/user/login',
          method: 'POST',
          header: {
            'content-type': 'application/json',
          },
          data:{
            code: res.code,
            user:{
                name:app.globalData.userInfo.nickName,
                school:school_name,
                avatar:app.globalData.userInfo.avatarUrl
            }
          },
          success: res => {
            console.log(res)
            //保存token
            wx.setStorage({
              data: res.data.data,
              key: 'token',
            })
          },
          fail: err =>{
            console.log(err)
          }
        })
      } else {
        console.log(res.errMsg)
      }
    }
  })

}

const get = (url) => {
  let promise = new Promise(function(resolve,reject){   
    wx.request({
      url: url,
      method: 'GET',
      success(res){
        resolve(res)
      },
      fail(err){
        reject(err)
      }
    })
  })
  return promise
}

// 生成uuid
const guid = () => {
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
      var r = Math.random() * 16 | 0,
          v = c == 'x' ? r : (r & 0x3 | 0x8);
      return v.toString(16);
  });
}


module.exports = {
  formatTime,
  wxRequest,
  wxGetStorage,
  login,
  initLogin,
  get,
  post,
  guid
}
