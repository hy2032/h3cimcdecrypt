package com.imcdecrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // 创建主窗口
        JFrame frame = new JFrame("H3C IMC MSSQL UI解密工具");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // 设置字体
        Font labelFont = new Font("Serif", Font.BOLD, 24); // 标签字体，大小 24
        Font textFont = new Font("Serif", Font.PLAIN, 20); // 输入框和按钮字体，大小 20

        // 输入加密内容
        JLabel encryptedLabel = new JLabel("加密内容:");

        JTextArea encryptedTextArea = new JTextArea(5, 30);
        encryptedLabel.setFont(labelFont); // 设置标签字体
        encryptedTextArea.setFont(textFont); // 设置加密内容输入框字体
        JScrollPane encryptedScrollPane = new JScrollPane(encryptedTextArea);
        encryptedTextArea.setLineWrap(true);

        // 解密后的内容
        JLabel decryptedLabel = new JLabel("解密结果:");
        decryptedLabel.setFont(labelFont); // 设置标签字体
        JTextArea decryptedTextArea = new JTextArea(5, 30);
        decryptedTextArea.setFont(textFont); // 设置加密内容输入框字体
        decryptedTextArea.setEditable(false); // 解密结果是只读的
        JScrollPane decryptedScrollPane = new JScrollPane(decryptedTextArea);
        decryptedTextArea.setLineWrap(true);

        // 解密按钮
        JButton decryptButton = new JButton("解密");
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String encryptedContent = encryptedTextArea.getText(); // 获取输入的加密内容

                try {
                    // 调用解密方法并显示结果
                    String decryptedContent = decrypt.decrypt(encryptedContent);
                    decryptedTextArea.setText(decryptedContent);
                } catch (Exception ex) {
                    decryptedTextArea.setText("解密失败：" + ex.getMessage());
                }
            }
        });

        // 布局设置
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(encryptedLabel, BorderLayout.NORTH);
        inputPanel.add(encryptedScrollPane, BorderLayout.CENTER);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(decryptedLabel, BorderLayout.NORTH);
        resultPanel.add(decryptedScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(decryptButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // 显示窗口
        frame.setVisible(true);
    }
}