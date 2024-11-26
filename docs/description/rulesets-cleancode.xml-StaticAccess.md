Static access increases dependencies and makes code hard to test. Use dependency injection through constructors instead for better modularity. Example:
```php
class MyClass {
    private $dependency;

    public function __construct($dependency) {
        $this->dependency = $dependency;
    }
}
```

<!-- Codacy PatPatBot reviewed: 2024-05-24T11:34:41.151Z -->
