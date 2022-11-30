package MiniProjects.WrapperPattern;

public class ExampleWrapper extends Example {
    private Example original;
    public ExampleWrapper(Example example)
    {
        super(example.getName());
        this.original = example;
    }

    public String getName()
    {
        return "Это пример класса обертки :" + original.getName();
    }

    public void setName(String name)
    {
        original.setName(name);
    }
}
