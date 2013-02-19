

public class WordPictureSound {
	private String Word;
	private SoundClass SoundObj;
	public WordPictureSound(String Word, String SoundFile) {
		this.Word = Word;
		SoundObj = new SoundClass(SoundFile);
	}
	
	public void PlaySound() {
		SoundObj.PlaySound();
	}
	
	public String GetWordString() {
		return Word;
	}
}
