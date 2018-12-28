// pages/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    areaId: undefined,
    areaName: "",
    priority: "",
    addUrl: "http://127.0.0.1:8080/demo/area/insertArea",
    modifyUrl: "http://127.0.0.1:8080/demo/area/updateArea"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    if (options.areaId == undefined) {
      return;
    }
    this.setData({
      areaId: options.areaId
    });
    wx.request({
      url: 'http://127.0.0.1:8080/demo/area/selectAreaById',
      data: { "areaId": options.areaId },
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        var code = res.data.code;
        if (code == 200) {
          var msg = res.data.msg;
          wx.showToast({
            title: msg,
            image: 'images/timg.jpg',
            duration: 2000,
            mask: true
          });
        } else {
          that.setData({
            areaName: res.data.data.data.areaName,
            priority: res.data.data.data.priority
          });
        }
      }
    })

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

  /**
   * add
   */
  formSubmit: function (data) {
    var that = this;
    var formData = data.detail.value;
    var url = that.data.addUrl;
    console.log(formData);
    console.log(that.data.areaId);
    if (that.data.areaId != undefined) {
      formData.areaId = that.data.areaId;
      url = that.data.modifyUrl;
    }
    console.log(formData);
    wx.request({
      url: url,
      data: JSON.stringify(formData),
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },  
      success: function (res) {
        var result = res.data.code;
        var toastText = "操作成功！";
        if (result == 200) {
          toastText = "操作失败" + res.data.msg;
        }
        // wx.showToast({
        //   title: toastText,
        //   image: '/images/timg.jpg',
        //   duration: 2000
        // });
        wx.showLoading();
        wx.hideLoading();
        setTimeout(() => {
          wx.showToast({
            title: toastText,
            image: '/images/timg.jpg',
          });
          setTimeout(() => {
            wx.hideToast();
          }, 2000)
        }, 0);
        if (that.data.areaId == undefined) {
          wx.redirectTo({
            url: '../list/list',
          })
        }
      }
    })
  }
})