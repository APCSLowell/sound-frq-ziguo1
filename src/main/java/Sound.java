import java.util.*;
public class Sound
{
  /** the array of values in this sound; guaranteed not to be null */
  int[] samples;



  /** Changes those values in this sound that have an amplitude greater than limit.
   *  Values greater than limit are changed to limit.
   *  Values less than -limit are changed to -limit.
   *  @param limit the amplitude limit
   *         Precondition: limit >= 0
   *  @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit)
  {  
    /* to be implemented in part (a) */
    int cnt = 0;
    for (int i = 0; i < samples.length; i++) {
      int amp = Math.abs(samples[i]), multi = samples[i] >= 0 ? 1 : -1;
      if (amp > limit) {
        cnt++;
        samples[i] = limit * multi;
      }
    }
    return cnt;
  }



  /** Removes all silence from the beginning of this sound.
   *  Silence is represented by a value of 0.
   *  Precondition: samples contains at least one nonzero value
   *  Postcondition: the length of samples reflects the removal of starting silence
   */
  public void trimSilenceFromBeginning()
  {
    /* to be implemented in part (b) */
    int leadingZeroes = 0;
    for (int val : samples) {
      if (val != 0) break;
      leadingZeroes++;
    }
    int[] cpy = new int [samples.length - leadingZeroes];
    for (int i = leadingZeroes; i < samples.length; i++) {
      cpy[i - leadingZeroes] = samples[i];
    }
    samples = cpy;
  }
}
