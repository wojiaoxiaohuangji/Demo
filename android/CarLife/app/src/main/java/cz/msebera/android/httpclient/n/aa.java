package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;

@Immutable
public class aa
  implements w
{
  private final String a;
  
  public aa()
  {
    this(null);
  }
  
  public aa(String paramString)
  {
    this.a = paramString;
  }
  
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    a.a(paramu, "HTTP request");
    if (!paramu.containsHeader("User-Agent"))
    {
      paramg = null;
      Object localObject = paramu.getParams();
      if (localObject != null) {
        paramg = (String)((j)localObject).a("http.useragent");
      }
      localObject = paramg;
      if (paramg == null) {
        localObject = this.a;
      }
      if (localObject != null) {
        paramu.addHeader("User-Agent", (String)localObject);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */