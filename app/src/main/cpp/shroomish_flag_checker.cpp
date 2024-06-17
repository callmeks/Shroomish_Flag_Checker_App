#include <jni.h>
#include <string>

static const std::string v =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        "abcdefghijklmnopqrstuvwxyz"
        "0123456789+/";
static const std::string OP = "shroomish";

static const std::string ggez = "QFpEXF8vWjEsMVgzWFxfW0paS1FKXl1eLzJQSlEwKS5aWktZMls0LltfUEJRQFpBKi0=";

std::string last(const std::string& input) {

    std::string result;
    int val = 0, bits = -6;

    for (unsigned char c : input) {
        val = (val << 8) + c;
        bits += 8;
        while (bits >= 0) {
            result += v[(val >> bits) & 0x3F];
            bits -= 6;
        }
    }
    if (bits > -6) {
        result += v[((val << 8) >> (bits + 8)) & 0x3F];
    }
    while (result.size() % 4) {
        result += '=';
    }
    return result;
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_shroomish_1flag_1checker_wee_eee(JNIEnv* env, jobject /* this */, jstring input) {
    const char* inputCStr = env->GetStringUTFChars(input, nullptr);
    std::string S = std::string(inputCStr);
    std::string OP = "testing 1";
    env->ReleaseStringUTFChars(input, inputCStr);

    std::string check ;
    for (int i = 0; i < S.length(); i++){
        check += S[i] ^ ::OP[i % OP.size()];
    }

    std::string last1 = last(check);
    std::string ggez = "SilGXFZeXjFfMV4wWy1UK0dbNSkzLlYvWzEuMlEzWC1bWkMqSls0Ll5fWzFYMV4wX1ZdUENRQ1E2LS5eXUBcMVEwKS5ZK0oqNSlFXFgvKEAuMlpBXy0rKEBbRVtCLVwvLDE=";

    if (last1 == ::ggez ) {
        return JNI_TRUE;
    }
    return JNI_FALSE;
}
