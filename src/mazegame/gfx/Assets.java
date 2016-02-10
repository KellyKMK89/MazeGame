package mazegame.gfx;

import java.awt.image.BufferedImage;

import mazegame.gfx.ImageLoader;
import mazegame.gfx.SpriteSheet;

/* Crop and store all sprites from the sprite sheets in arrays to be used for animation
 * Crop and store textures from sprite sheets to be used as tiles */

public class Assets {
	
	private static final int width = 32, height = 32;

	public static BufferedImage player, floor, wall, bone, sand, stone, grass, hedge, door;
	public static BufferedImage[] playerUp, playerDown, playerLeft, playerRight;
	public static BufferedImage[] zombieUp, zombieDown, zombieLeft, zombieRight;
	public static BufferedImage[] mummyUp, mummyDown, mummyLeft, mummyRight;
	public static BufferedImage[] skelUp, skelDown, skelLeft, skelRight;
	
	public static void init(){
		SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/textures/ssTiles.png"));
		SpriteSheet ssPlayer = new SpriteSheet(ImageLoader.loadImage("/textures/ssPlayer.png"));
		SpriteSheet ssZombie = new SpriteSheet(ImageLoader.loadImage("/textures/ssZombie.png"));
		SpriteSheet ssMummy = new SpriteSheet(ImageLoader.loadImage("/textures/ssMummy.png"));
		SpriteSheet ssSkeleton = new SpriteSheet(ImageLoader.loadImage("/textures/ssSkeleton.png"));
		
		//player = ssPlayer.crop(0, 0, width, height);
		floor = tileSheet.crop(width, 0, width, height);
		wall = tileSheet.crop(0, 0, width, height);	
		sand = tileSheet.crop(width*2, height, width, height);
		stone = tileSheet.crop(width*2, 0, width, height);
		hedge = tileSheet.crop(0, height, width, height);
		grass = tileSheet.crop(width, height, width, height);

		door = tileSheet.crop(0, height*2+1, width, height);
		
		//Bone
		bone = ImageLoader.loadImage("/textures/imgBone.png");
		
		
		//PLAYER SHEET- arrays that hold the animation frames

		playerDown = new BufferedImage[3];
			playerDown[0] = ssPlayer.crop(0, 0, width, height);	
			playerDown[1] = ssPlayer.crop(width, 0, width, height);
			playerDown[2] = ssPlayer.crop(width*2, 0, width, height);
		playerLeft = new BufferedImage[3];
			playerLeft[0] = ssPlayer.crop(0, height, width, height);
			playerLeft[1] = ssPlayer.crop(width, height, width, height);
			playerLeft[2] = ssPlayer.crop(width*2, height, width, height);
		playerRight = new BufferedImage[3];
			playerRight[0] = ssPlayer.crop(0, height*2, width, height);
			playerRight[1] = ssPlayer.crop(width, height*2, width, height);
			playerRight[2] = ssPlayer.crop(width*2, height*2, width, height);
		playerUp = new BufferedImage[3];
			playerUp[0] = ssPlayer.crop(0, height*3, width, height);
			playerUp[1] = ssPlayer.crop(width, height*3, width, height);
			playerUp[2] = ssPlayer.crop(width*2, height*3, width, height);
			
			
		//ZOMBIE SHEET
			
		zombieDown = new BufferedImage[3];
			zombieDown[0] = ssZombie.crop(0, 0, width, height);			
			zombieDown[1] = ssZombie.crop(width, 0, width, height);
			zombieDown[2] = ssZombie.crop(width*2, 0, width, height);
		zombieLeft = new BufferedImage[3];
			zombieLeft[0] = ssZombie.crop(0, height, width, height);
			zombieLeft[1] = ssZombie.crop(width, height, width, height);
			zombieLeft[2] = ssZombie.crop(width*2, height, width, height);
		zombieRight = new BufferedImage[3];
			zombieRight[0] = ssZombie.crop(0, height*2, width, height);
			zombieRight[1] = ssZombie.crop(width, height*2, width, height);
			zombieRight[2] = ssZombie.crop(width*2, height*2, width, height);
		zombieUp = new BufferedImage[3];
			zombieUp[0] = ssZombie.crop(0, height*3, width, height);
			zombieUp[1] = ssZombie.crop(width, height*3, width, height);
			zombieUp[2] = ssZombie.crop(width*2, height*3, width, height);
			
			
		//MUMMY SHEET
			
		mummyDown = new BufferedImage[3];
			mummyDown[0] = ssMummy.crop(0, 0, width, height);			
			mummyDown[1] = ssMummy.crop(width, 0, width, height);
			mummyDown[2] = ssMummy.crop(width*2, 0, width, height);
		mummyLeft = new BufferedImage[3];
			mummyLeft[0] = ssMummy.crop(0, height, width, height);
			mummyLeft[1] = ssMummy.crop(width, height, width, height);
			mummyLeft[2] = ssMummy.crop(width*2, height, width, height);
		mummyRight = new BufferedImage[3];
			mummyRight[0] = ssMummy.crop(0, height*2, width, height);
			mummyRight[1] = ssMummy.crop(width, height*2, width, height);
			mummyRight[2] = ssMummy.crop(width*2, height*2, width, height);
		mummyUp = new BufferedImage[3];
			mummyUp[0] = ssMummy.crop(0, height*3, width, height);
			mummyUp[1] = ssMummy.crop(width, height*3, width, height);
			mummyUp[2] = ssMummy.crop(width*2, height*3, width, height);
			
			
		//SKELETON SHEET
			
		skelDown = new BufferedImage[3];
			skelDown[0] = ssSkeleton.crop(0, 0, width, height);			
			skelDown[1] = ssSkeleton.crop(width, 0, width, height);
			skelDown[2] = ssSkeleton.crop(width*2, 0, width, height);
		skelLeft = new BufferedImage[3];
			skelLeft[0] = ssSkeleton.crop(0, height, width, height);
			skelLeft[1] = ssSkeleton.crop(width, height, width, height);
			skelLeft[2] = ssSkeleton.crop(width*2, height, width, height);
		skelRight = new BufferedImage[3];
			skelRight[0] = ssSkeleton.crop(0, height*2, width, height);
			skelRight[1] = ssSkeleton.crop(width, height*2, width, height);
			skelRight[2] = ssSkeleton.crop(width*2, height*2, width, height);
		skelUp = new BufferedImage[3];
			skelUp[0] = ssSkeleton.crop(0, height*3, width, height);
			skelUp[1] = ssSkeleton.crop(width, height*3, width, height);
			skelUp[2] = ssSkeleton.crop(width*2, height*3, width, height);

	}
}
