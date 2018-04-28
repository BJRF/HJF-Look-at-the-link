package com.hjf.lookGame1227;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class GameListener implements ActionListener,MouseListener,Config{
	JPanel j;
	Graphics g;
	Random r=new Random();
	private int x1,y1,x2,y2,xx1,yy1,xx2,yy2,xx,yy,count,count1,space;
	private int [][]lookarray=new int[LINE][LINE];
	ImageIcon img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;
	
	//���췽��
	public GameListener(JPanel j,Graphics g){
		this.j=j;
		this.g=g;
		img1=new ImageIcon(this.getClass().getResource("1.jpg"));
		img2=new ImageIcon(this.getClass().getResource("2.jpg"));
		img3=new ImageIcon(this.getClass().getResource("3.jpg"));
		img4=new ImageIcon(this.getClass().getResource("4.jpg"));
		img5=new ImageIcon(this.getClass().getResource("5.jpg"));
		img6=new ImageIcon(this.getClass().getResource("6.jpg"));
		img7=new ImageIcon(this.getClass().getResource("7.jpg"));
		img8=new ImageIcon(this.getClass().getResource("8.jpg"));
		img9=new ImageIcon(this.getClass().getResource("9.jpg"));
		img10=new ImageIcon(this.getClass().getResource("10.jpeg"));			
	}
	//�����ά����ķ���
	public void point(){
		for(int i=0;i<LINE;i++){
			if(x1>X+SIZE*i&&x1<X+SIZE*(i+1)){
				xx1=i;
			}
			if(y1>Y+SIZE*i&&y1<Y+SIZE*(i+1)){
				yy1=i;
			}
		}
		for(int i=0;i<LINE;i++){
			if(x2>X+SIZE*i&&x2<X+SIZE*(i+1)){
				xx2=i;
			}
			if(y2>Y+SIZE*i&&y2<Y+SIZE*(i+1)){
				yy2=i;
			}
		}
	}
	//�����2��ͬ��ɫ�ķ���ķ���
	public void equal(){
		for(int i=0;i<12;i++){
			for(int j=0;j<10;j++){
				lookarray[i][j]=0;
			}
		}
		for(int i=0;i<1000000;i++){
				int c=r.nextInt(LINE-3)+1;
				int d=r.nextInt(LINE-3)+1;
				int f=r.nextInt(LINE-3)+1;
				int g=r.nextInt(LINE-3)+1;
				int h=r.nextInt(10)+1;
				if(lookarray[c][d]==0&&lookarray[f][g]==0){
					lookarray[c][d]=h;
					lookarray[f][g]=h;
				}
		}		
	}
	//�����������ͬ��ɫ�������ķ���
	public void white(){
		if(lookarray[xx1][yy1]==lookarray[xx2][yy2]){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(Color.WHITE);
			g.fillRect(X+xx1*SIZE, Y+yy1*SIZE, SIZE, SIZE);
			g.fillRect(X+xx2*SIZE, Y+yy2*SIZE, SIZE, SIZE);
			lookarray[xx1][yy1]=0;
			lookarray[xx2][yy2]=0;
		}
	}
	//�ж��Ƿ�������ߵķ���
	//����
	public void wuzhe(){
		if(yy1==yy2){
			if(xx1>xx2){
				for(int i=0;i<xx1-xx2-1;i++){
					if(lookarray[xx1-1-i][yy1]==0){
						count++;
					}
				}
			}
			if(xx1<xx2){
				for(int i=0;i<xx2-xx1-1;i++){
					if(lookarray[xx2-1-i][yy1]==0){
						count++;
					}
				}
			}
			if(count==Math.abs(xx2-xx1)-1||count==Math.abs(yy2-yy1)-1){
				this.white();
				}
				count=0;
		}
		if(xx1==xx2){
			if(yy1>yy2){
				for(int i=0;i<yy1-yy2-1;i++){
					if(lookarray[xx1][yy1-1-i]==0){
						count++;
					}
				}
			}
			if(yy1<yy2){
				for(int i=0;i<yy2-yy1-1;i++){
					if(lookarray[xx1][yy2-1-i]==0){
						count++;
					}
				}
			}
			if(count==Math.abs(xx2-xx1)-1||count==Math.abs(yy2-yy1)-1){
			this.white();
			}
			count=0;
		}
	}
	//һ��
	public void yizhe(int xx1,int yy1,int xx2,int yy2){
		if(yy1!=yy2&&xx1!=xx2){
			count--;
			count1--;
			if((xx1>xx2&&yy1>yy2)||(xx1<xx2&&yy1<yy2)){
				if((lookarray[Math.max(xx1, xx2)-1][Math.max(yy1, yy2)]==0&&lookarray[Math.min(xx1, xx2)][Math.min(yy1, yy2)+1]==0)||(lookarray[Math.min(xx1, xx2)+1][Math.min(yy1, yy2)]==0&&lookarray[Math.max(xx1, xx2)][Math.max(yy1, yy2)-1]==0)){
					count++;
					count1++;
					for(int i=0;i<Math.abs(xx1-xx2)-1;i++){
						if(lookarray[Math.max(xx1, xx2)-1-i][yy1]==0){
							count++;
						}
					}
					for(int j=0;j<Math.abs(yy1-yy2)-1;j++){
						if(lookarray[xx1][Math.max(yy1, yy2)-1-j]==0){
							count1++;
						}
					}
				}
			}
			if((xx1>xx2&&yy1<yy2)||(xx1<xx2&&yy1>yy2)){
				if((lookarray[Math.max(xx1, xx2)-1][Math.min(yy1, yy2)]==0&&lookarray[Math.min(xx1, xx2)][Math.max(yy1, yy2)-1]==0)||(lookarray[Math.max(xx1, xx2)][Math.min(yy1, yy2)+1]==0&&lookarray[Math.min(xx1, xx2)+1][Math.max(yy1, yy2)]==0)){
					count++;
					count1++;
					for(int i=0;i<Math.abs(xx1-xx2)-1;i++){
						if(lookarray[Math.max(xx1, xx2)-1-i][yy1]==0){
							count++;
						}
					}
					for(int i=0;i<Math.abs(yy1-yy2)+1;i++){
						if(lookarray[xx1][Math.min(yy1, yy2)+1+i]==0){
							count1++;
						}
					}
				}
				//������������Ƿ���Ч
//				System.out.println(count+","+count1);
			}
				if(count==Math.abs(xx2-xx1)-1||count1==Math.abs(yy2-yy1)-1){
					this.white();
				}
				count=0;
				count1=0;
		}
	}
	//����
	public void erzhe(){
		if(xx1!=xx2||yy1!=yy2){
				for(int i=1;i<12-xx2;i++){
					if(lookarray[xx2+i][yy2]==0){
						xx=xx2+i;
						lookarray[xx][yy2]=lookarray[xx2][yy2];
						this.yizhe(xx1, yy1, xx, yy2);
						lookarray[xx][yy2]=0;
					}else{
						break;
					}
				}
				for(int i=1;i<12-yy2;i++){
					if(lookarray[xx2][yy2+i]==0){
						yy=yy2+i;
						lookarray[xx2][yy]=lookarray[xx2][yy2];
						this.yizhe(xx1,yy1,xx2,yy);
						lookarray[xx2][yy]=0;
					}else{
						break;
					}
				}
				for(int i=1;i<xx2+1;i++){
					if(lookarray[xx2-i][yy2]==0){
						xx=xx2-i;
						lookarray[xx][yy2]=lookarray[xx2][yy2];
						this.yizhe(xx1,yy1,xx,yy2);
						lookarray[xx][yy2]=0;
					}else{
						break;
					}
				}
				for(int i=1;i<yy2+1;i++){
					if(lookarray[xx2][yy2-i]==0){
						yy=yy2-i;
						lookarray[xx2][yy]=lookarray[xx2][yy2];
						this.yizhe(xx1,yy1,xx2,yy);
						lookarray[xx2][yy]=0;
					}else{
						break;
					}
				}
		}
	}
	//ʤ���Ľ���
	public void win(){
		javax.swing.JFrame jf = new javax.swing.JFrame();
		java.awt.FlowLayout fl = new java.awt.FlowLayout();
		jf.setLayout(fl);
		javax.swing.JLabel jlb = new javax.swing.JLabel("��ϲ����ʤ�ˣ������¿�ʼ");
		jlb.setFont(new java.awt.Font("Dialog", 1, 100));
		// ��dialog���������壬1������ʽ(1�Ǵ��壬0��ƽ���ģ�15���ֺ�
		jf.setSize(500, 200);
		jf.add(jlb);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		jf.setVisible(true);
	}
	//ʵ�ְ�ť����
	public void actionPerformed(ActionEvent e) {
		//����괫��������Դﵽ�������ʼ��Ϸ��ǰ���ܶ������в���
		if(e.getActionCommand().equals("��ʼ��Ϸ")){
			j.addMouseListener(this);
			this.equal();
			//���巽�����ɫ/ͼƬ��ֵ
			for(int i=0;i<LINE-2;i++){
				for(int j=0;j<LINE-2;j++){
					if(lookarray[i][j]==1){
//						g.setColor(Color.YELLOW);
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img1.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==2){
//						g.setColor(Color.BLACK);
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img2.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==3){
//						g.setColor(Color.GREEN);
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img3.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==4){
//						g.setColor(Color.PINK);
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img4.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==5){
//						g.setColor(Color.RED);
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img5.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==6){
//						g.setColor(Color.BLUE);
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img6.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==7){
//						g.setColor(Color.ORANGE);
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img7.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==8){
//						g.setColor(Color.LIGHT_GRAY);
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img8.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==9){
//						g.setColor(new Color(155,255,185));
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img9.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==10){
//						g.setColor(new Color(155,255,185));
//						g.fillRect(X+i*SIZE, Y+j*SIZE, SIZE, SIZE);
						g.drawImage(img10.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
				}
			}
			
		}
		if(e.getActionCommand().equals("���¿�ʼ")){
			j.addMouseListener(this);
			this.equal();
			for(int i=0;i<LINE-2;i++){
				for(int j=0;j<LINE-2;j++){
					if(lookarray[i][j]==1){
						g.drawImage(img1.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==2){
						g.drawImage(img2.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==3){
						g.drawImage(img3.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==4){
						g.drawImage(img4.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==5){
						g.drawImage(img5.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==6){
						g.drawImage(img6.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==7){
						g.drawImage(img7.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==8){
						g.drawImage(img8.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==9){
						g.drawImage(img9.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
					if(lookarray[i][j]==10){
						g.drawImage(img10.getImage(),X+i*SIZE, Y+j*SIZE, SIZE, SIZE,null);
					}
				}
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		x1=e.getX();
		y1=e.getY();
		if(x2!=0&&y2!=0){
			//���㽻��
			this.point();
			System.out.println(xx1+"  "+yy1);
			System.out.println("look   "+lookarray[xx1][yy1]);
			//�����������ͬ��ɫʱ������
			if(xx1!=xx2||yy1!=yy2){
				this.wuzhe();
				this.yizhe(xx1,yy1,xx2,yy2);
				this.erzhe();
			}
		}
		x2=x1;
		y2=y1;
		for(int i=0;i<12;i++){
			for(int j=0;j<12;j++){
				if(lookarray[i][j]==0){
					space++;
					//���Կո��ӵ������ǹ���ȷ
					System.out.println(space);
				}
				if(space==144){
					this.win();
				}
			}
		}
		space=0;
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

}
