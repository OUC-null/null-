Page({

  /**
   * 页面的初始数据
   */
  data: {
    stuId: '',//学号
    noinput: false,//没有学号输入
    pwd: '',//密码
    nopwd: false,//没有密码输入
    disabled: false,//输入均为空
  },

  noinput: function (e) {
    this.setData({ stuId: e.detail.value });
    this.setData({ noinput: true });
    if (this.data.noinput == true && this.data.nopwd == true) {
      this.setData({ disabled: false });
    }
  },

  nopwd: function (e) {
    this.setData({ pwd: e.detail.value });
    this.setData({ nopwd: true });
    if (this.data.noinput == true && this.data.nopwd == true) {
      this.setData({ disabled: false });
    }
  },

  formSubmit: function (e) {
    wx.showLoading({
      title: '登录中...',
    })
    console.log(e);
    this.setData({ disabled: false });
    wx.request({
      data: {
        stuId: e.detail.value.stuId,
        pwd: e.detail.value.pwd
      },
      url: 'http://localhost:8080/../..?stuId='+stuId+'?pwd='+pwd,
      success: function (res) {
        console.log(res);
        if (res.statusCode == 200) {//访问正常
          if (res.data.error == true) {
            wx.showToast({
              title: res.data.msg,
              icon: 'none',
              duration: 2000
            })
          } else {
            //key:stu(是个数组)，data
            wx.setStorage({
              key: 'stu',
              data: 'res.data.stu',
            })
            wx.showToast({
              title: "登陆成功",
              icon: 'success',
              duration: 2000
            })
            setTimeout(function () {   //定时器->跳转
              wx.switchTab({
                url: '../homepage/homepage',
              })
            }, 2000)
          }
        } else {
          wx.showToast({
            title: '服务器出现错误',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
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
    if (this.data.stuId == '' || this.data.pwd == '') {
      this.setData({ disabled: true });
    } else {
      this.setData({ disabled: false });
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

  }
})