package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.k.v;
import cz.msebera.android.httpclient.u;
import java.io.IOException;

@NotThreadSafe
public class k
  extends b<u>
{
  public k(i parami)
  {
    this(parami, null);
  }
  
  public k(i parami, v paramv)
  {
    super(parami, paramv);
  }
  
  protected void a(u paramu)
    throws IOException
  {
    this.c.a(this.b, paramu.getRequestLine());
    this.a.a(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */