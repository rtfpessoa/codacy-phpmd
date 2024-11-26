Exit statements make code untestable and harder to maintain. Instead, handle termination logic in higher-level scripts, returning appropriate error codes to the caller.

Incorrect:
```
class Foo {
    public function bar($param) {
        if ($param === 42) {
            exit(23);
        }
    }
}
```

<!-- Codacy PatPatBot reviewed: 2024-05-24T11:40:38.352Z -->
