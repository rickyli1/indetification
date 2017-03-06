<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE HTML>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>UMEDITOR</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/ueditor/umeditor1_2_2-utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="/ueditor/umeditor1_2_2-utf8-jsp/third-party/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor/umeditor1_2_2-utf8-jsp/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor/umeditor1_2_2-utf8-jsp/umeditor.min.js"></script>
    <script type="text/javascript" src="/ueditor/umeditor1_2_2-utf8-jsp/lang/zh-cn/zh-cn.js"></script>
    <style type="text/css">
        h1{
            font-family: "å¾®è½¯éé»";
            font-weight: normal;
        }
        .btn {
            display: inline-block;
            *display: inline;
            padding: 4px 12px;
            margin-bottom: 0;
            *margin-left: .3em;
            font-size: 14px;
            line-height: 20px;
            color: #333333;
            text-align: center;
            text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
            vertical-align: middle;
            cursor: pointer;
            background-color: #f5f5f5;
            *background-color: #e6e6e6;
            background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6));
            background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -o-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: linear-gradient(to bottom, #ffffff, #e6e6e6);
            background-repeat: repeat-x;
            border: 1px solid #cccccc;
            *border: 0;
            border-color: #e6e6e6 #e6e6e6 #bfbfbf;
            border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
            border-bottom-color: #b3b3b3;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#ffe6e6e6', GradientType=0);
            filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
            *zoom: 1;
            -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn:hover,
        .btn:focus,
        .btn:active,
        .btn.active,
        .btn.disabled,
        .btn[disabled] {
            color: #333333;
            background-color: #e6e6e6;
            *background-color: #d9d9d9;
        }

        .btn:active,
        .btn.active {
            background-color: #cccccc \9;
        }

        .btn:first-child {
            *margin-left: 0;
        }

        .btn:hover,
        .btn:focus {
            color: #333333;
            text-decoration: none;
            background-position: 0 -15px;
            -webkit-transition: background-position 0.1s linear;
            -moz-transition: background-position 0.1s linear;
            -o-transition: background-position 0.1s linear;
            transition: background-position 0.1s linear;
        }

        .btn:focus {
            outline: thin dotted #333;
            outline: 5px auto -webkit-focus-ring-color;
            outline-offset: -2px;
        }

        .btn.active,
        .btn:active {
            background-image: none;
            outline: 0;
            -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn.disabled,
        .btn[disabled] {
            cursor: default;
            background-image: none;
            opacity: 0.65;
            filter: alpha(opacity=65);
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
        }
    </style>
</head>
<body>

<!--styleç»å®å®½åº¦å¯ä»¥å½±åç¼è¾å¨çæç»å®½åº¦-->
<script type="text/plain" id="myEditor" style="width:1000px;height:240px;">
    <p>è¿éæå¯ä»¥åä¸äºè¾å¥æç¤º</p>
</script>


<div class="clear"></div>
<div id="btns">
    <table>
        <tr>
            <td>
                <button class="btn" unselected="on" onclick="getAllHtml()">è·å¾æ´ä¸ªhtmlçåå®¹</button>&nbsp;
                <button class="btn" onclick="getContent()">è·å¾åå®¹</button>&nbsp;
                <button class="btn" onclick="setContent()">åå¥åå®¹</button>&nbsp;
                <button class="btn" onclick="setContent(true)">è¿½å åå®¹</button>&nbsp;
                <button class="btn" onclick="getContentTxt()">è·å¾çº¯ææ¬</button>&nbsp;
                <button class="btn" onclick="getPlainTxt()">è·å¾å¸¦æ ¼å¼ççº¯ææ¬</button>&nbsp;
                <button class="btn" onclick="hasContent()">å¤æ­æ¯å¦æåå®¹</button>
            </td>
        </tr>
        <tr>
            <td>
                <button class="btn" onclick="setFocus()">ç¼è¾å¨è·å¾ç¦ç¹</button>&nbsp;
                <button class="btn" onmousedown="isFocus();return false;">ç¼è¾å¨æ¯å¦è·å¾ç¦ç¹</button>&nbsp;
                <button class="btn" onclick="doBlur()">ç¼è¾å¨åæ¶ç¦ç¹</button>&nbsp;
                <button class="btn" onclick="insertHtml()">æå¥ç»å®çåå®¹</button>&nbsp;
                <button class="btn" onclick="getContentTxt()">è·å¾çº¯ææ¬</button>&nbsp;
                <button class="btn" id="enable" onclick="setEnabled()">å¯ä»¥ç¼è¾</button>&nbsp;
                <button class="btn" onclick="setDisabled()">ä¸å¯ç¼è¾</button>
            </td>
        </tr>
        <tr>
            <td>
                <button class="btn" onclick="UM.getEditor('myEditor').setHide()">éèç¼è¾å¨</button>&nbsp;
                <button class="btn" onclick="UM.getEditor('myEditor').setShow()">æ¾ç¤ºç¼è¾å¨</button>&nbsp;
                <button class="btn" onclick="UM.getEditor('myEditor').setHeight(300)">è®¾ç½®ç¼è¾å¨çé«åº¦ä¸º300</button>&nbsp;
                <button class="btn" onclick="UM.getEditor('myEditor').setWidth(1200)">è®¾ç½®ç¼è¾å¨çå®½åº¦ä¸º1200</button>
            </td>
        </tr>

    </table>
</div>
<table>
    <tr>
        <td>
            <button class="btn" onclick="createEditor()"/>åå»ºç¼è¾å¨</button>
            <button class="btn" onclick="deleteEditor()"/>å é¤ç¼è¾å¨</button>
        </td>
    </tr>
</table>

<div>
    <h3 id="focush2"></h3>
</div>
<script type="text/javascript">
    //å®ä¾åç¼è¾å¨
    var um = UM.getEditor('myEditor');
    um.addListener('blur',function(){
        $('#focush2').html('ç¼è¾å¨å¤±å»ç¦ç¹äº')
    });
    um.addListener('focus',function(){
        $('#focush2').html('')
    });
    //æé®çæä½
    function insertHtml() {
        var value = prompt('æå¥htmlä»£ç ', '');
        um.execCommand('insertHtml', value)
    }
    function isFocus(){
        alert(um.isFocus())
    }
    function doBlur(){
        um.blur()
    }
    function createEditor() {
        enableBtn();
        um = UM.getEditor('myEditor');
    }
    function getAllHtml() {
        alert(UM.getEditor('myEditor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("ä½¿ç¨editor.getContent()æ¹æ³å¯ä»¥è·å¾ç¼è¾å¨çåå®¹");
        arr.push("åå®¹ä¸ºï¼");
        arr.push(UM.getEditor('myEditor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("ä½¿ç¨editor.getPlainTxt()æ¹æ³å¯ä»¥è·å¾ç¼è¾å¨çå¸¦æ ¼å¼ççº¯ææ¬åå®¹");
        arr.push("åå®¹ä¸ºï¼");
        arr.push(UM.getEditor('myEditor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("ä½¿ç¨editor.setContent('æ¬¢è¿ä½¿ç¨umeditor')æ¹æ³å¯ä»¥è®¾ç½®ç¼è¾å¨çåå®¹");
        UM.getEditor('myEditor').setContent('æ¬¢è¿ä½¿ç¨umeditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UM.getEditor('myEditor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UM.getEditor('myEditor').setEnabled();
        enableBtn();
    }

    function getText() {
        //å½ä½ ç¹å»æé®æ¶ç¼è¾åºåå·²ç»å¤±å»äºç¦ç¹ï¼å¦æç´æ¥ç¨getTextå°ä¸ä¼å¾å°åå®¹ï¼æä»¥è¦å¨éåæ¥ï¼ç¶ååå¾åå®¹
        var range = UM.getEditor('myEditor').selection.getRange();
        range.select();
        var txt = UM.getEditor('myEditor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("ä½¿ç¨editor.getContentTxt()æ¹æ³å¯ä»¥è·å¾ç¼è¾å¨ççº¯ææ¬åå®¹");
        arr.push("ç¼è¾å¨ççº¯ææ¬åå®¹ä¸ºï¼");
        arr.push(UM.getEditor('myEditor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("ä½¿ç¨editor.hasContents()æ¹æ³å¤æ­ç¼è¾å¨éæ¯å¦æåå®¹");
        arr.push("å¤æ­ç»æä¸ºï¼");
        arr.push(UM.getEditor('myEditor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UM.getEditor('myEditor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UM.getEditor('myEditor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            domUtils.removeAttributes(btn, ["disabled"]);
        }
    }
</script>

</body>
</html>