`Goto` statements complicate code readability and control flow. Replace them with structured control mechanisms for better clarity and maintainability.

Issue example:
```php
class Foo {
    public function bar($param) {
        A:
        if ($param === 42) {
            goto X;
        }
        Y:
        if (time() % 42 === 23) {
            goto Z;
        }
        X:
        if (time() % 23 === 42) {
            goto Y;
        }
        Z:
        return 42;
    }
}
```

Solution:
```php
class Foo {
    public function bar($param) {
        if ($param === 42) {
            return 42;
        }
        if (time() % 42 === 23) {
            return 42;
        }
        if (time() % 23 === 42) {
            return 42;
        }
        return 42;
    }
}
```

<!-- Codacy PatPatBot reviewed: 2024-05-24T11:41:26.020Z -->
