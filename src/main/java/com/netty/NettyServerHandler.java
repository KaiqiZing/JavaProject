package com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * �Զ���Handler��Ҫ�̳�netty�涨�õ�ĳ��HandlerAdapter(�淶)
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * ���ͻ������ӷ�������ɾͻᴥ���÷���
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("�ͻ�������ͨ���������");
    }

    /**
     * ��ȡ�ͻ��˷��͵�����
     *
     * @param ctx �����Ķ���, ����ͨ��channel���ܵ�pipeline
     * @param msg ���ǿͻ��˷��͵�����
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //Channel channel = ctx.channel();
        //ChannelPipeline pipeline = ctx.pipeline(); //������һ��˫������, ��վ��վ
        //�� msg ת��һ�� ByteBuf������NIO �� ByteBuffer
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("�յ��ͻ��˵���Ϣ:" + buf.toString(CharsetUtil.UTF_8));
    }

    /**
     * ���ݶ�ȡ��ϴ�����
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ByteBuf buf = Unpooled.copiedBuffer("HelloClient".getBytes(CharsetUtil.UTF_8));
        ctx.writeAndFlush(buf);  // �����д��Ϣ���͸��ͻ���

    }

    /**
     * �����쳣, һ������Ҫ�ر�ͨ��
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}