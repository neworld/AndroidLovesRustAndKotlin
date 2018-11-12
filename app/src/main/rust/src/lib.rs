extern crate jni;
extern crate md5;

use jni::JNIEnv;
use jni::objects::{JClass, JString};
use jni::sys::jstring;

#[no_mangle]
#[allow(non_snake_case)]
pub extern "C" fn Java_lt_neworld_rust_MainActivity_md5(env: JNIEnv,
                                                        _class: JClass,
                                                        input: JString) -> jstring {
    let input: String = env.get_string(input).expect("Couldn't get java string!").into();
    let digest = md5::compute(input);
    let output = env.new_string(format!("{:x}", digest)).expect("Couldn't create java string!");

    output.into_inner()
}
