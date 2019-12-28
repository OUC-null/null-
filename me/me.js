//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
   id:"17020031096",
   phone:"12345678901",
   info:"zfagbshtjydzsfbgnfjdt111111111111111111111111111111111111111"
  },

 relaunch:function(){
   wx.reLaunch({
     url: '/pages/login/login',
   })
 },

 myReleased:function(){
   wx.navigateTo({
     url: '/pages/myReleased/myReleased',
   })
 },

  mySale: function () {
    wx.navigateTo({
      url: '/pages/mySale/mySale',
    })
  },

  mBuyIn: function () {
    wx.navigateTo({
      url: '/pages/mBuyIn/mBuyIn',
    })
  },

  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })

  },
  getUserInfo: function (e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
