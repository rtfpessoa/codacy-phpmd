Calculates the number of possible execution paths in your methods. High NPath complexity, typically over 200, suggests the need for refactoring to improve maintainability.

Example:

```
function foo($value) {
    $result = '';
    if($value % 3 == 0) {
        $result .= 'divisible by 3';
    }
    if($value % 5 == 0) {
        $result .= 'divisible by 5';
    }
    if(!$result) {
        $result = $value;
    }
    return $result;
}
// NPath complexity: 8
```

<!-- Codacy PatPatBot reviewed: 2024-05-24T11:35:24.530Z -->
