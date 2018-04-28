package com.hjf.lookGame1227;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jframe extends GamePanel{
	public void show(){
		JFrame jf =new JFrame();
		//���ý����һЩ��������
		jf.setSize(900, 800);
		jf.setTitle("������С��Ϸ");
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		//���һ������ڽ�����
		GamePanel gp=new GamePanel();
		//�����м�������ɫ
		gp.setBackground(new Color(255,255,255));
		jf.add(gp,BorderLayout.CENTER);
		//��ʽ�������ö��ߵİ�ť���ֵ�����
		JPanel jp=new JPanel();
		jp.setBackground(new Color(245,245,245));
		FlowLayout fl=new FlowLayout(FlowLayout.CENTER,10,180);
		jp.setLayout(fl);
		Dimension ed=new Dimension(120,0);
		jp.setPreferredSize(ed);
		jf.add(jp,BorderLayout.EAST);
		//���ö���������ɫ
		jp.setBackground(new Color(245,245,245));
		//���ð�ť
		javax.swing.JButton jbu1=new javax.swing.JButton("��ʼ��Ϸ");
		Dimension d1=new Dimension(100,60);
		jbu1.setPreferredSize(d1);
		jp.add(jbu1);
		javax.swing.JButton jbu2=new javax.swing.JButton("���¿�ʼ");
		Dimension d2=new Dimension(100,60);
		jbu2.setPreferredSize(d2);
		jp.add(jbu2);
		//���ӻ�
		jf.setVisible(true);
		//�������ӻ���
		Graphics g=gp.getGraphics();
		//����ť��Ӽ�����
		GameListener gl=new GameListener(gp,g);
		jbu1.addActionListener(gl);
		jbu2.addActionListener(gl);
	}

	public static void main(String[] args) {
		Jframe j=new Jframe();
		j.show();
	}

}
