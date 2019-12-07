//Marriage.java	



package ch06.q1;

public class Marriage
{
  private Male   him;
  private Female her;
  public Marriage(Male m, Female f) {
    him = m;
    her = f;
    him.SetSpouse(this);
    her.SetSpouse(this);
  }
  public Male husband() { return him; }
  public Female wife() { return her; }
}

