Directly accessing PHP superglobals scatters dependencies and poses security risks. Instead, encapsulate their access within a request class provided by your framework to enhance maintainability and security.

Example:
``
// Direct access - not recommended
$name = $_POST['foo'];

// Encapsulated access - recommended
$name = $request->get('foo');
``

<!-- Codacy PatPatBot reviewed: 2024-05-24T11:38:48.061Z -->
