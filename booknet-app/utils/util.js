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
const wxRequestToken = (url,data,token) => {
  let promise = new Promise(function(resolve,reject){
    wx.request({
      method: 'POST',
      url: base_url+url,
      data:data,  
      header:{
        'content-type': 'application/json',
        'Authorization': 'Bearer ' + token
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

// 封装 wx.getUserInfo
const wxGetUserInfo = () =>{
  let promise = new Promise(function(resolve,reject){
    wx.getUserInfo({
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

module.exports = {
  formatTime,
  wxRequestToken,
  wxRequest,
  wxGetStorage,
  wxGetUserInfo
}
