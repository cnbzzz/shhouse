<xml>
    <ToUserName><![CDATA[${fromUserName!}]]></ToUserName>
    <FromUserName><![CDATA[${toUserName!}]]></FromUserName>
    <CreateTime>${createTime!}</CreateTime>
    <MsgType><![CDATA[news]]></MsgType>
    <ArticleCount><#if (articles??)>${articles?size}<#else>0</#if></ArticleCount>
    <#if (articles?? && articles?size>0) >
    <Articles>
        <#list articles as art>
        <item>
            <Title><![CDATA[${art.title!}]]></Title>
            <Description><![CDATA[${art.desc!}]]></Description>
            <PicUrl><![CDATA[${art.picUrl!}]]></PicUrl>
            <Url><![CDATA[${art.url!}]]></Url>
        </item>
        </#list>
    </Articles>
    </#if>
</xml>