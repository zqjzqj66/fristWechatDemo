// pages/list/list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: []

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
      var that =this;
      wx.request({
        url: 'http://127.0.0.1:8080/demo/area//selectAllArea',
        method: 'GET',
        data: {},
        success:function(re){
            var code = re.data.code;
            if(code ==100){
              var list =re.data.data.data;
              that.setData({
                list:list
              })
            }else{
              var toast = '获取数据失败';
              wx.showToast({
                title: toast,
                image: '/images/timg.jpg',
                duration: 10000
              })
            }
        }
      })
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
   * 页面相关事件处理函数--监听用户 下拉动作
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
   * 添加
   */
  addArea: function (data) {
      wx.navigateTo({
        url: '../operation/operation',
      })
  },

  /**
   * 添加
   */
  deleteArea: function (data) {
    var that=this;
    wx.showModal({
      title: '提示',
      content: '确定要删除'+data.target.dataset.areaname+'吗？',
      success: function(res) {
        if(res.confirm){
          wx.request({
            url: 'http://127.0.0.1:8080/demo/area/deleteArea',
            data: { areaId: data.target.dataset.areaid},
            method: 'GET',
            success: function(res) {
              var tosast='';
              var code = res.data.code;
              if(code==100){
                tosast="删除成功";
                 /**wx.navigateTo({
                  url: '../list/list'
                })
               */
                that.data.list.splice(data.target.dataset.index, 1);
                that.setData({
                  list: that.data.list
                })
              }else{
                tosast = "删除失败";
              }
              wx.showToast({
                title: tosast,
                image: '/images/timg.jpg',
                duration: 2000
              })
            }
          })
        }
      }
    })
  }
})