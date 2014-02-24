Memory model:
| Type | Bytes |
| :--: | :---: |
| boolean | 1 |
| byte | 1 |
| char | 2 |
| int | 4 |
| float | 4 |
| long | 8 |
| double | 8 |
| reference | 8 |
| array | 24 + (type-size) * N |

Objects are complicated:
16 bytes of overhead
Pad out to multiples of 8