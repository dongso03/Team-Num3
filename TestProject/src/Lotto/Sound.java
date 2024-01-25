package Lotto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Sound extends JFrame implements ActionListener {

    // 음악 재생 메서드
    public void Play(String fileName) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 생성자
    public Sound() {
        JButton musicButton = new JButton("음악 재생");
        musicButton.addActionListener(this);

        getContentPane().add(musicButton);

        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        // 주석 처리된 부분을 해제하여 음악이 재생되도록 합니다.
    	if ("음악 재생".equals(e.getActionCommand())) {
    		Play("C:\\으악2.wav"); // 음악재생 메서드 호출. 파라미터로 파일의 위치와 이름을 써줘야 한다.
         }
    }

    public static void main(String[] args) {
        new Sound();
    }
}
