`Eval` expressions are risky, hard to test, and reduce code quality. Avoid using `eval` by substituting with regular code constructs. For example:

```php
// Avoid
eval('$param = 23;');

// Safer alternative
$param = 23;
```

<!-- Codacy PatPatBot reviewed: 2024-05-24T11:40:54.376Z -->
