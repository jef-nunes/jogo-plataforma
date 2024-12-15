package utils;

public class Constants {
	public static class Direcoes
	{
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}
	public static class JogadorConst
	{
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMPING = 2;
		public static int GetQuantSprites(int ato)
		{
			switch(ato)
			{
				case IDLE:
					return 4;
				case RUNNING:
					return 5;
				case JUMPING:
					return 2;
				default:
					return 1;
			}
		}
	}
}
